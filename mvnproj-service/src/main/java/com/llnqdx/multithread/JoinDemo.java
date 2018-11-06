package com.llnqdx.multithread;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: llnqdx
 * @Date: 2018/11/6
 * @Description:
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("t3");
        });

        //join 当前主线程等待，子线程继续执行
        t1.start();
        t1.join();//wait/notify
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
