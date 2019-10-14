package com.zhangpingyang.springcloud_consumer;

import com.zhangpingyang.springcloud_consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/14 17:19
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name)
    {
        return helloService.hiService(name);
    }
}
