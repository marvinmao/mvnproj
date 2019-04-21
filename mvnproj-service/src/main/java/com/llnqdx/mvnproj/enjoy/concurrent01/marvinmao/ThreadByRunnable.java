package com.llnqdx.mvnproj.enjoy.concurrent01.marvinmao;


/**
 * @Description:
 * @author: marvinmao
 * @Date: 2019-4-21
 */
public class ThreadByRunnable implements Runnable {

    private int i;

    @Override
    public void run() {
        System.out.println("current thread:" + Thread.currentThread().getName());

        for (; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadByRunnable threadByRunnable = new ThreadByRunnable();
        new Thread(threadByRunnable, "new thread one").start();
        new Thread(threadByRunnable, "new thread two").start();
    }
}
