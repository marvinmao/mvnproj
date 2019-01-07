package com.llnqdx.mvnproj.enjoy.ch1.safeend;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:如何安全的中断线程
 */
public class EndRunnable {
    private static class UseRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(threadName + " is run");
            }
            System.out.println(threadName + " interrupt is " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread thread = new Thread(useRunnable, "endRunnable");
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
