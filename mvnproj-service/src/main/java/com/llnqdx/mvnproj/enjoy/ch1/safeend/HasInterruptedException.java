package com.llnqdx.mvnproj.enjoy.ch1.safeend;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:
 */
public class HasInterruptedException {
    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            /**
             * 方法里如果抛出InterruptedException，线程的中断标志位会被复位成false，如果确实是需要中断线程，
             * 需要我们自己在catch语句块里再次调用interrupt()
             * */
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupted flag is " + isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("HasInterruptedEx");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
