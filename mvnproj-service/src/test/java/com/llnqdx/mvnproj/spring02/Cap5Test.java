package com.llnqdx.mvnproj.spring02;

import com.llnqdx.mvnproj.enjoy.spring02.cap5.config.Cap5MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap5Test {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5MainConfig.class);

        System.out.println("IOC容器创建完成........");


    }
}
