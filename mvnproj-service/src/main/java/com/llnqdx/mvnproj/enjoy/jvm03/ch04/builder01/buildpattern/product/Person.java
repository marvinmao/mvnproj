package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product;


/**
 * @author marvinmao
 * <p>
 * 类说明：产品类，抽象的
 */
public abstract class Person {

    protected String head;
    protected String body;
    protected String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
