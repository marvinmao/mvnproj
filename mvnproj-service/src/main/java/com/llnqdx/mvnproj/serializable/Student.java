package com.llnqdx.mvnproj.serializable;

import java.io.Serializable;

class Student implements Serializable {
    private String name;
    private int age;
    public static int QQ = 1234;
    private transient String address = "CHINA";
    Student(String name, int age ){
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "name: " + name + "\n" +"age: " + age + "\n" +"QQ: "
                + QQ + "\n" + "address: " + address;
    }
    public void SetAge(int age) {
        this.age = age;
    }
}