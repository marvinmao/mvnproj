package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern;

import com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product.Person;

/**
 * @author marvinmao
 * <p>
 * 类说明：抽象建造者
 */
public abstract class PersonBuilder {

    //建造部件
    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildFoot();

    public abstract Person createPerson();

}
