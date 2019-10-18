package com.zhangpingyang.springcloud_consumer.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/16 16:01
 */
public class Receiver {
    public final static String QUEUE_NAME = "hello";
    @Value("${mq.username}")
    private String username;
    @Value("${mq.password}")
    private String password;



}
