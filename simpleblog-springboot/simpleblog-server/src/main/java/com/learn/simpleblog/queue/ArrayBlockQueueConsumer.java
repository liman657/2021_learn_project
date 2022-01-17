package com.learn.simpleblog.queue;

import com.learn.simpleblog.api.utils.BlogMsg;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.lucene.LuceneBlogService;
import com.learn.simpleblog.module.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * autor:liman
 * createtime:2022-01-17
 * comment:监听ArrayBlockQueue的消费者
 */
@Component
@Slf4j
public class ArrayBlockQueueConsumer {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private LuceneBlogService luceneBlogService;

    //通过cron表达式进行定时轮询监听获取数据，每2秒搜索一次
    @Scheduled(cron = "0/2 * * * * ?")
    public void listenMsg(){
        try {
            while (Constant.BLOG_Queue.size()>0){
                BlogMsg msg=Constant.BLOG_Queue.poll();

                //根据不同的事件类型type执行不同的动作
                if (Objects.equals(msg.getType(),Constant.BlogIndexMsg.Create.getType()) || Objects.equals(msg.getType(),Constant.BlogIndexMsg.Active.getType())){
                    log.info("内部队列开始处理：{}微博事件，微博id为:{}更新索引库中的信息",msg.getType(),msg.getBlogId());
                    luceneBlogService.createDocument(blogMapper.selectByPK(msg.getBlogId()));

                }else if (Objects.equals(msg.getType(),Constant.BlogIndexMsg.Delete.getType()) || Objects.equals(msg.getType(),Constant.BlogIndexMsg.UnActive.getType())){
                    log.info("内部队列开始处理:{}微博事件，微博id为:{},从索引库中删除",msg.getType(),msg.getBlogId());
                    luceneBlogService.deleteDocument(msg.getBlogId());
                }
            }
        }catch (Exception e){
            log.error("微博事件处理出现异常，异常信息为:{}",e);
        }
    }
}
