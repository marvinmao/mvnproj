package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern;


import com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product.Man;
import com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product.Person;

/**
 * @author marvinmao
 * <p>
 * 类说明：具体建造者
 */
public class ManBuilder extends PersonBuilder {

    private Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("Brave Head");

    }

    @Override
    public void buildBody() {
        person.setBody("Strong body");

    }

    @Override
    public void buildFoot() {
        person.setFoot("powful foot");

    }

    @Override
    public Person createPerson() {
        return person;
    }


}
