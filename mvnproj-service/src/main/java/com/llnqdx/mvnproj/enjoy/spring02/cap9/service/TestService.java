package com.llnqdx.mvnproj.enjoy.spring02.cap9.service;

import com.llnqdx.mvnproj.enjoy.spring02.cap9.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Qualifier("testDao")//指定名称来加载
    @Autowired
    private TestDao testDao;//如果使用Autowired, testDao2, 找到TestDao类型的

    public void println() {
        System.out.println("Service...dao...." + testDao);
    }
}
