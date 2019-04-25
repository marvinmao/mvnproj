package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product;


/**
 * @author marvinmao
 * <p>
 * 类说明：具体的产品
 */
public class Man extends Person {
    public Man() {
        System.out.println("create a man");
    }

    @Override
    public String toString() {
        return "Man{}";
    }
}
