package com.llnqdx.mvnproj.dubbozk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author maofujiang
 * @Description:
 * @since 2018/11/21
 */
public class StartProducer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("provider.xml");

        app.start();

        System.out.println("服务发布成功...");

        System.in.read();//让程序阻塞。

    }
}
