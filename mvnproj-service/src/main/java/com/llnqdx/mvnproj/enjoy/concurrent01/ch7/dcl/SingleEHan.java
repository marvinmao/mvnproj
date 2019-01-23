package com.llnqdx.mvnproj.enjoy.concurrent01.ch7.dcl;

/**
 * @Auther: marvinmao
 * 饿汉式
 */
public class SingleEHan {
    public static SingleEHan singleEHan = new SingleEHan();

    private SingleEHan() {
    }

}
