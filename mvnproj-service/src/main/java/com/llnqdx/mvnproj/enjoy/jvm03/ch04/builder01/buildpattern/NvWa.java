package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern;

import com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern.product.Person;

/**
 * @author marvinmao
 * <p>
 * 类说明：导演者
 */
public class NvWa {

    public Person buildPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.createPerson();
    }

}
