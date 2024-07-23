package com.llnqdx.mvnproj.serializable;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        //创建可序列化对象 System.out.println("原来的对象：");
        Student stu = new Student("Ming", 16);
        System.out.println(stu); //创建序列化输出流

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buff);
        //将序列化对象存入缓冲区
        out.writeObject(stu);
        //修改相关值
        Student.QQ = 6666;
        // 发现打印结果QQ的值被改变
        stu.SetAge(18);
        //发现值没有被改变
        //从缓冲区取回被序列化的对象
        ObjectInputStream in = new ObjectInputStream(new
                ByteArrayInputStream(buff.toByteArray()));
        Student newStu = (Student) in.readObject();
        System.out.println("序列化后取出的对象：");
        System.out.println(newStu);
    }
}