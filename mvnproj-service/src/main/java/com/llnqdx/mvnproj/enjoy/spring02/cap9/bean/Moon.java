package com.llnqdx.mvnproj.enjoy.spring02.cap9.bean;

import org.springframework.stereotype.Component;

@Component
public class Moon {
    public Moon() {
        System.out.println("Moon constructor........");
    }

    public void init() {
        System.out.println("Moon....init......");
    }


    public void destroy() {
        System.out.println("Moon....destroy......");
    }
}