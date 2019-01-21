package com.llnqdx.mvnproj;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/17
 * @Description:
 */
public class FatherClazzTest {

    protected void sayHello() throws Exception {
        System.out.println("Hello father");
    }

    public static void main(String[] args) {
        ChildClazzTest s = new ChildClazzTest();
        s.sayHello();
    }
}
