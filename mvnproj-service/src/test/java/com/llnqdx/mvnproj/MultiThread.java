package com.llnqdx.mvnproj;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/17
 * @Description:
 */
public class MultiThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName());
        try {
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThread t1 = new MultiThread();
        t1.start();
        MultiThread t2 = new MultiThread();
        t2.start();
        t2.join();
        t1.join();
    }
}
