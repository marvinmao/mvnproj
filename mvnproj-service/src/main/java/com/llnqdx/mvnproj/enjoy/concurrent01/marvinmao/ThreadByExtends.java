package com.llnqdx.mvnproj.enjoy.concurrent01.marvinmao;


/**
 * @Description:
 * @author: marvinmao
 * @Date: 2019-4-21
 */
public class ThreadByExtends extends Thread {

    @Override
    public void run() {
        System.out.println("current thread:" + getName());

        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + ":" + i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new ThreadByExtends().start();
        new ThreadByExtends().start();
    }
}
