package com.llnqdx.mvnproj.multithread;

public class CreateDemo {
    public static final int MAX_TURN = 5;
    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }
    public static Thread getCurThread() {
        return Thread.currentThread();
    }
    //线程的编号
    static int threadNo = 1;
    static class DemoThread extends Thread { //①
        public DemoThread() {
            super("DemoThread-" + threadNo++); //②
        }
        public void run() { //③
            for (int i = 1; i < MAX_TURN; i++) {
                System.out.println(getName() + ", 轮次：" + i);
            }
            System.out.println(getName() + " 运行结束.");
        }
    }
    public static void main(String args[]) throws InterruptedException {
        Thread thread = null;
        //方法一：使用Thread子类创建和启动线程
        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }
        System.out.println(getCurThreadName() + " 运行结束.");
    }
}