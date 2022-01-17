package com.learn.simpleblog.queue;/**
 * Created by Administrator on 2021/1/20.
 */

import com.learn.simpleblog.api.utils.BlogMsg;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.lucene.LuceneBlogService;
import com.learn.simpleblog.module.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 基本事件驱动的消费者 继承ApplicationListener
 */
@Component
@Slf4j
public class BlogQueueConsumer implements ApplicationListener<BlogMsg>{

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private LuceneBlogService luceneBlogService;

    @Override
    public void onApplicationEvent(BlogMsg msg) {
        //根据不同的事件类型type执行不同的动作
        try {
            //如果是创建或者激活
            if (Objects.equals(msg.getType(),Constant.BlogIndexMsg.Create.getType()) || Objects.equals(msg.getType(),Constant.BlogIndexMsg.Active.getType())){
                log.info("开始处理：{}微博事件，微博id为:{}更新索引库中的信息",msg.getType(),msg.getBlogId());
                luceneBlogService.createDocument(blogMapper.selectByPK(msg.getBlogId()));
            }else if (Objects.equals(msg.getType(),Constant.BlogIndexMsg.Delete.getType()) || Objects.equals(msg.getType(),Constant.BlogIndexMsg.UnActive.getType())){
                //如果是删除或者屏蔽
                log.info("开始处理:{}微博事件，微博id为:{},从索引库中删除",msg.getType(),msg.getBlogId());
                luceneBlogService.deleteDocument(msg.getBlogId());
            }

        }catch (Exception e){
            log.error("微博事件处理出现异常，异常信息为:{}",e);
        }
    }
}





























