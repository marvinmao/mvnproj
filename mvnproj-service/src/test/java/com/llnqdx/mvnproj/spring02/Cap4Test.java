package com.llnqdx.mvnproj.spring02;

import com.llnqdx.mvnproj.enjoy.spring02.cap4.config.Cap4MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap4Test {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4MainConfig.class);

        System.out.println("IOC�����������........");
        app.getBean("person");//ִ�л�ȡ��ʱ��Ŵ�������ʼ��bean

    }
}
