package com.llnqdx.mvnproj.enjoy.concurrent01.ch7.safeclass;

/**
 * @Auther: marvinmao
 * <p>
 * 类说明：无状态的类，没有任何的成员变量
 */
public class StatelessClass {

    public int service(int a, int b) {
        return a * b;
    }

    //...public void t(){}

}
