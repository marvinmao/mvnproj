package com.llnqdx.mvnproj.enjoy.spring02.cap9.config;

import com.llnqdx.mvnproj.enjoy.spring02.cap9.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.llnqdx.mvnproj.enjoy.spring02.cap9.controller", "com.llnqdx.mvnproj.enjoy.spring02.cap9.service", "com.llnqdx.mvnproj.enjoy.spring02.cap9.dao", "com.llnqdx.mvnproj.enjoy.spring02.cap9.bean"})
public class Cap9MainConfig {
    //spring进行自装配的时候默认首选的bean
    @Primary //只要在这里申请Primary, 代表所有要注入TestDao的bean,
    @Bean("testDao2")
    public TestDao testDao() {
        TestDao testDao = new TestDao();
        testDao.setFlag("2");
        return testDao;
    }
}
