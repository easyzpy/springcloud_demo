package com.zhangpingyang.springcloud_producer.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/16 16:01
 */
//@Configuration
//@EnableAsync
//@EnableScheduling
public class Sender {
    public final static String QUEUE_NAME = "hello";
    private final static Log log = LogFactory.getLog(Sender.class);
//    @Autowired
//    private SpringSender springSender;


//    @Scheduled(cron = "0 */1 * * * ?")
//    public void test2() {
//        log.info("mq scheduled start");
////        springSender
//        log.info("mq scheduled end");
//    }
    @Value("${mq.username}")
    private String username;
    @Value("${mq.password}")
    private String password;
    Channel channel;
    public Sender() throws IOException, TimeoutException {
        ConnectionFactory fac = new ConnectionFactory();
        fac.setPort(5672);
        fac.setHost("106.15.238.84");
        fac.setUsername("zhazha");
        fac.setPassword("123");
        Connection connection = fac.newConnection();
        channel = connection.createChannel();
        Map<String, Object> map = new HashMap<>();
//        map.put("currentTime", new Date());
        channel.queueDeclare(QUEUE_NAME, false, false, false, map);
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void test1() throws IOException {
        log.info("mq scheduled start");

        channel.basicPublish("", QUEUE_NAME, null, "Hello World".getBytes());

        log.info("mq scheduled end");

    }

}
