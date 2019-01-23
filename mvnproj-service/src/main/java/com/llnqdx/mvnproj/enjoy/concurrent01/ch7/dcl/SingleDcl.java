package com.llnqdx.mvnproj.enjoy.concurrent01.ch7.dcl;

/**
 * @Auther: marvinmao
 * 懒汉式-双重检查
 */
public class SingleDcl {
    private volatile static SingleDcl singleDcl;

    private SingleDcl() {
    }

    public static SingleDcl getInstance() {
        if (singleDcl == null) {
            synchronized (SingleDcl.class) {//类锁
                if (singleDcl == null) {
                    singleDcl = new SingleDcl();
                }
            }
        }
        return singleDcl;
    }
}
