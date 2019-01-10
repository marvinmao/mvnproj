package com.llnqdx.mvnproj.enjoy.concurrent01.ch1.safeend;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:如何安全的中断线程
 */
public class EndThread {
    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            //while (true) 不会中断线程，体现出协作式
            while (!isInterrupted()) {
                System.out.println(threadName + " is run");
            }
            System.out.println(threadName + " interrupt is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread("endThread");
        useThread.start();
        Thread.sleep(20);
        useThread.interrupt();
    }
}
