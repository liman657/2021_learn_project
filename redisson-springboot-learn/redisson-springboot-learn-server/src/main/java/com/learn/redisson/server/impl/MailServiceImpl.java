package com.learn.redisson.server.impl;

import com.learn.redisson.module.entity.MailInfo;
import com.learn.redisson.module.mapper.MailInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMapCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * autor:liman
 * createtime:2021/3/30
 * comment: MapCache 模拟邮件发送的服务类
 */
@Service("mailService")
@Slf4j
public class MailServiceImpl {

    @Autowired
    private Environment environment;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailInfoMapper mailInfoMapper;

    //TODO:发送简单的邮件消息
    @Async
    public void sendSimpleEmail(final String subject,final String content,final String ... tos){
        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(subject);
            message.setText(content);
            message.setTo(tos);
            message.setFrom(environment.getProperty("mail.send.from"));
            mailSender.send(message);

            log.info("--【模拟即时发送】发送简单的邮件消息 成功--");
        }catch (Exception e){
            log.error("--发送简单的邮件消息，发生异常：",e.fillInStackTrace());
        }
    }



}
