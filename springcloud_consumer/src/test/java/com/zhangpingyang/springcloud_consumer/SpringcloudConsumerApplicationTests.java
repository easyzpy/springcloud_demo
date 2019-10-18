package com.zhangpingyang.springcloud_consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudConsumerApplicationTests {
    public final static String QUEUE_NAME = "hello";
    @Value("${mq.username}")
    private String username;
    @Value("${mq.password}")
    private String password;

    @Test
    public void contextLoads() throws IOException, TimeoutException {
//        System.out.println(username + " " +password);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("106.15.238.84");
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            System.out.println(consumerTag);
        });

    }

}
