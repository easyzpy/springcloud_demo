package com.zhangpingyang.springcloud_producer.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/18 18:01
 */
@Configuration
@EnableScheduling
public class SenderSpring {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    @Scheduled(cron = "0 */1 * * * ?")
    public void test1() {
//        System.out.println("sdfsdf");
//        rabbitTemplate.convertAndSend(queue, "foo");
        rabbitTemplate.setDefaultReceiveQueue("spring_cloud_test_queue");
        rabbitTemplate.send(new Message("spring_cloud_message".getBytes(), new MessageProperties()));
    }
}
