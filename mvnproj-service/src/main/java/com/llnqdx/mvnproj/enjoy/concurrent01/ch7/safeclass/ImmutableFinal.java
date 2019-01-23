package com.llnqdx.mvnproj.enjoy.concurrent01.ch7.safeclass;


/**
 * @Auther: marvinmao
 * <p>
 * 类说明：不可变的类
 */
public class ImmutableFinal {

    private final int a;
    private final int b;

    public ImmutableFinal(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


}