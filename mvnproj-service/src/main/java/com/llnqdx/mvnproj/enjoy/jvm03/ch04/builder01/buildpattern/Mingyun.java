package com.llnqdx.mvnproj.enjoy.jvm03.ch04.builder01.buildpattern;

/**
 * @author marvinmao
 * <p>
 * 类说明：客户端
 */
public class Mingyun {

    public static void main(String[] args) {
        System.out.println("create NvWa");
        NvWa nvwa = new NvWa();
        nvwa.buildPerson(new ManBuilder());
        nvwa.buildPerson(new WomanBuilder());

    }
}
