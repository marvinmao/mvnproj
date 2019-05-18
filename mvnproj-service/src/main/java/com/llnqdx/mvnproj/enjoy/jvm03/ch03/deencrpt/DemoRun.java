package com.llnqdx.mvnproj.enjoy.jvm03.ch03.deencrpt;

/**
 * @author-maovinmao 创建日期：2017/08/31
 * 创建时间: 14:39
 */
public class DemoRun {

    public static void main(String[] args) throws Exception {
        DemoCustomClassLoader demoCustomClassLoader = new DemoCustomClassLoader("My ClassLoader");
        demoCustomClassLoader.setBasePath("D:\\Test\\encrpt\\dest\\");
        Class<?> clazz = demoCustomClassLoader.loadClass("DemoTarget");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
    }
}
