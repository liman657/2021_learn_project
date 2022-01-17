package com.learn.simpleblog.lucene;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.Blog;
import com.learn.simpleblog.service.blog.IBlogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.poi.ss.formula.functions.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 针对 blog 微博数据表建立的lucene操作服务类
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Component
@Slf4j
public class LuceneBlogService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IBlogService blogService;

    @Autowired
    private Environment environment;

    @Autowired
    private static final Analyzer analyzer = new MyIKAnalyzer();

    //需要在用户微博发送成功之后，微博数据存入数据库时，需要更新到索引库中
    //更新到索引库的步骤，包含对微博数据进行分词，然后插入到底层lucene索引库，并建立映射
    public void createDocument(final Blog blog){
        IndexWriter indexWriter = null;
        try{
            //创建Lucene的索引文档根目录
            FSDirectory directory = FSDirectory.open(Paths.get(environment.getProperty("lucene.index.directory")));

            //索引写入配置类
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

            //设置创建索引的模式,指定在原来的索引基础上创建或者追加
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

            //索引的读写器
            indexWriter = new IndexWriter(directory,indexWriterConfig);

            //开始创建文档（相当于微博表中的一条条微博数据）
            Document document = new Document();

            //为文档添加字段，并指定每个字段是否存储，是否分词，按照前端需要展示什么就尽可能的将字段和数据加入到Lucene的数据库中

            //FieldType，指定的是不需要分词的属性，完全相等的时候才匹配
            FieldType fieldType=new FieldType();
            fieldType.setIndexOptions(IndexOptions.DOCS);
            fieldType.setStored(true);
            //Store属性，指定是否存储
            //DoubleField，FloatField，IntField，LongField，StringField一定会被索引，但是不分词
            document.add(new StringField("id",String.valueOf(blog.getId()), Field.Store.YES));
            //TextField 一定会被索引，一定会分词
            document.add(new TextField("content",blog.getContent(), Field.Store.YES));
            document.add(new StringField("userId",String.valueOf(blog.getUserId()), Field.Store.YES));
            document.add(new StringField("type",String.valueOf(blog.getType()), Field.Store.YES));
            document.add(new StringField("blogId", String.valueOf(Objects.isNull(blog.getBlogId())?-1:blog.getBlogId()), Field.Store.YES));
            document.add(new StringField("createTime", Constant.DATE_TIME_FORMAT.format(blog.getCreateTime()), Field.Store.YES));
            document.add(new StringField("isActive",String.valueOf(blog.getIsActive()), Field.Store.YES));
            document.add(new StringField("isDelete",String.valueOf(blog.getIsDelete()), Field.Store.YES));
            document.add(new Field("userName",blog.getUserName(),fieldType));
            document.add(new Field("nickName",blog.getNickName(), fieldType));
            document.add(new Field("headerImg", StringUtils.isBlank(blog.getHeaderImg())?"":blog.getHeaderImg(), fieldType));
            //写入索引库，提交事务
            indexWriter.addDocument(document);
            indexWriter.commit();

            //关闭写入器
            indexWriter.close();
            log.info("当前微博：{}，成功建立索引，加入到索引库",blog);

        }catch (Exception e){
            log.error("创建Lucene文档出现异常，异常信息为:{}",e);
        }finally {
            //关闭索引流写入器
            if(null!=indexWriter){
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    log.error("关闭索引读写流出现异常，异常信息为:{}",e);
                }
            }
        }
    }

    //删除微博时，也需要删除底层Lucene文档数据
    public boolean deleteDocument(final Integer id) throws Exception{
        if(Objects.isNull(id)){
            return false;
        }
        IndexWriter indexWriter = null;
        try{
            //创建Lucene的索引文档根目录
            FSDirectory directory = FSDirectory.open(Paths.get(environment.getProperty("lucene.index.directory")));

            //索引写入配置类
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

            //设置创建索引的模式,指定在原来的索引基础上创建或者追加
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

            //索引的读写器
            indexWriter = new IndexWriter(directory,indexWriterConfig);
            //直接根据id删除
            indexWriter.deleteDocuments(new Term("id",String.valueOf(id)));

            indexWriter.commit();
            indexWriter.close();
        }catch (Exception e){
            log.error("删除索引文件出现异常，异常信息为:{}",e);
        }finally {
            if(null!=indexWriter){
                indexWriter.close();
            }
        }
        return true;
    }

    /**
     * 提供全文索引的功能 耗时较长需要优化
     * @param queryText
     * @param pageSize
     * @param currPage
     * @return
     * @throws Exception
     */
    public PageUtil searchDocumentPage(String queryText, final int pageSize, final int currPage) throws Exception{
        List<Blog> list= Lists.newLinkedList();

        //创建索引的存储目录与分词器类型、索引写入器配置类
        FSDirectory directory=FSDirectory.open(Paths.get(environment.getProperty("lucene.index.directory")));
        DirectoryReader reader=DirectoryReader.open(directory);
        IndexSearcher searcher=new IndexSearcher(reader);

        //查询解析器
        String[] fields = {"content","userName","nickName"};
        MultiFieldQueryParser parser = new MultiFieldQueryParser(fields,analyzer);
        Query query = parser.parse(queryText);

        //执行搜索，不支持物理分页，只能内存分页
        TopDocs docs = searcher.search(query, Integer.MAX_VALUE);
        Long total = docs.totalHits.value;
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        log.info("本次总共搜索到：{}条文档数据",total);

        //确定分页数据的起始位置和终止位置. 如：total=32条, pageSize=10条，第一页：start=0,end=9; 第二页：start=0,end=19; 第三页：start=0,end=29;
        //第四页：start=0,end=32
        int start=(currPage-1) * pageSize;
        int end=Math.min(start + pageSize,scoreDocs.length);
        Blog blog;
        Document searchDoc;
        //遍历得到的文档数据，进行封装处理
        for (int i=start;i<end;i++){
            //通过查询器的doc方法找到指定的文档
            searchDoc=searcher.doc(scoreDocs[i].doc);
            if (!Objects.isNull(searchDoc) && StringUtils.isNotBlank(searchDoc.get("id"))){
                try {
                    blog=new Blog();
                    blog.setId(Integer.valueOf(searchDoc.get("id")));

                    //内容-v1.0
                    //blog.setContent(searchDoc.get("content"));

                    //内容高亮显示-v2.0
                    blog.setContent(highLightContent(query,"content",searchDoc.get("content")));

                    blog.setUserId(Long.valueOf(searchDoc.get("userId")));
                    blog.setType(Integer.valueOf(searchDoc.get("type")));
                    blog.setBlogId(Integer.valueOf(searchDoc.get("blogId")));
                    blog.setCreateTime(Constant.DATE_TIME_FORMAT.parse(searchDoc.get("createTime")));
                    blog.setIsActive(Integer.valueOf(searchDoc.get("isActive")));
                    blog.setIsDelete(Integer.valueOf(searchDoc.get("isDelete")));

                    blog.setUserName(searchDoc.get("userName"));
                    blog.setNickName(searchDoc.get("nickName"));
                    blog.setHeaderImg(searchDoc.get("headerImg"));

                    blog.setImgUrls(StringUtils.isBlank(searchDoc.get("imgUrls")) ? Collections.emptyList() : objectMapper.readValue(searchDoc.get("imgUrls"),List.class) );

                    //对微博数据做二次处理
                    blogService.commonManageSingleBlog(blog);

                    list.add(blog);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


        directory.close();
        return new PageUtil(list,total.intValue(),pageSize,currPage);
    }

    //高亮处理指定字段的内容
    private static String highLightContent(Query query,final String fieldName,String fieldContent) throws Exception{
        //设置高亮标签,可以自定义,这里用html将其显示为红色
        SimpleHTMLFormatter formatter=new SimpleHTMLFormatter("<font color='red'>", "</font>");
        //得分
        QueryScorer scorer=new QueryScorer(query);
        //创建 段标签fragment
        Fragmenter fragmenter=new SimpleSpanFragmenter(scorer);
        //高亮分析器
        Highlighter highlighter=new Highlighter(formatter,scorer);
        highlighter.setTextFragmenter(fragmenter);

        //取出所有的片段
        String[] fragments=highlighter.getBestFragments(analyzer,fieldName,fieldContent,10000);
        return (!Objects.isNull(fragments) && fragments.length>0) ? fragments[0] : fieldContent;
    }

}
