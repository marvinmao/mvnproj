package com.llnqdx.mvnproj.multithread;

import static com.llnqdx.mvnproj.multithread.CreateDemo.getCurThreadName;

public class CreateDemo2 {
    public static final int MAX_TURN = 5;
    static int threadNo = 1;
    public static void main(String args[]) throws InterruptedException {
        Thread thread = null;
        //使用Runnable的匿名类创建和启动线程
        for (int i = 0; i < 2; i++) {
            thread = new Thread(new Runnable() { //① 匿名实例
                @Override
                public void run() { //② 异步执行的业务逻辑
                    for (int j = 1; j < MAX_TURN; j++) {
                        System.out.println(getCurThreadName() + ", 轮次：" + j);
                    }
                    System.out.println(getCurThreadName() + " 运行结束.");
                }
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        System.out.println(getCurThreadName() + " 运行结束.");
    }
}