package com.llnqdx.mvnproj.multithread;

import static com.llnqdx.mvnproj.multithread.CreateDemo.getCurThread;
import static com.llnqdx.mvnproj.multithread.SalesDemo.sleepMilliSeconds;

public class DaemonDemo {
    public static final int SLEEP_GAP = 500; //每一轮的睡眠时长
    public static final int MAX_TURN = 4; //用户线程执行轮次

    //守护线程实现类
    static class DaemonThread extends Thread {
        public DaemonThread() {
            super("daemonThread");
        }

        public void run() {
            System.out.println("--daemon线程开始.");
            for (int i = 1; ; i++) //死循环
            {
                System.out.println("--轮次：" + i);
                System.out.println("--守护状态为:" + isDaemon());
                // 线程睡眠一会，500毫秒
                sleepMilliSeconds(SLEEP_GAP);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        //创建一条用户线程，执行4轮
        Thread userThread = new Thread(() -> {
            System.out.println(">>用户线程开始.");
            for (int i = 1; i <= MAX_TURN; i++) {
                System.out.println(">>轮次：" + i);
                System.out.println(">>守护状态为:" + getCurThread().isDaemon());
                sleepMilliSeconds(SLEEP_GAP);
            }
            System.out.println(">>用户线程结束.");
        }, "userThread");
        //启动用户线程
        userThread.start();
        System.out.println(" 守护状态为:" + getCurThread().isDaemon());
        System.out.println(" 运行结束.");
    }
}