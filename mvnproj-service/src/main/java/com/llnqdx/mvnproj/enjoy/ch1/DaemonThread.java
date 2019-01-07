package com.llnqdx.mvnproj.enjoy.ch1;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:守护线程
 */
public class DaemonThread {
    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                while (!isInterrupted()) {
                    System.out.println("i am extends Thread, " + threadName + " is run");
                }
                System.out.println(threadName + " interrupt is " + isInterrupted());
            } finally {
                System.out.println(".......................finally");
            }
            System.out.println(threadName + " interrupt is " + isInterrupted());
        }
    }

    /**
     * 守护线程和主线程共死，finally不能保证一定执行
     * */
    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread("endThread");
        useThread.setDaemon(true);
        useThread.start();
        Thread.sleep(5);
//        useThread.interrupt();
    }
}
