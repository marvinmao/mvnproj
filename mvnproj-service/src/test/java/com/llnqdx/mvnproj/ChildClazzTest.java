package com.llnqdx.mvnproj;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/17
 * @Description:
 */
public class ChildClazzTest extends FatherClazzTest {

    @Override
    protected void sayHello() throws NullPointerException {
        System.out.println("hello child ");
    }
}
