package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product;


/**
 * @author marvinmao
 * <p>
 * 类说明：具体的产品
 */
public class Woman extends Person {

    public Woman() {
        System.out.println("create a Woman");
    }

    @Override
    public String toString() {
        return "Woman{}";
    }
}
