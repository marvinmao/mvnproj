package com.llnqdx.mvnproj.dubbozk;

import com.llnqdx.mvnproj.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author maofujiang
 * @Description:
 * @since 2018/11/21
 */
public class StartConsumer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("consumer.xml");

        app.start();

        UserService userService = (UserService) app.getBean("userService");

        String name = userService.getUser(1);

        System.out.println("消费端从生产者获取到 name:" + name);

        System.in.read();//让程序阻塞。

    }
}
