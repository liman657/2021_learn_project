package com.learn.simpleblog.lucene;

import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.module.domain.Blog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.apache.poi.ss.formula.functions.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
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

            indexWriter.close();
            indexWriter.commit();
        }catch (Exception e){
            log.error("删除索引文件出现异常，异常信息为:{}",e);
        }finally {
            if(null!=indexWriter){
                indexWriter.close();
            }
        }
        return true;
    }
    //提供全文档搜索功能


}
