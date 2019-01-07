package com.llnqdx.mvnproj.enjoy.ch1;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:
 */
public class RunAndStart {
    public static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 90;
            while (i > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i am " + Thread.currentThread().getName() + ", i=" + i--);
            }
        }
    }

    /**
     * run()和start() ：run方法就是普通对象的普通方法，只有调用了start()后，Java才会将线程对象和操作系统中实际的线程进行映射，再来执行run方法。
     */
    public static void main(String[] args) {
        ThreadRun beCalled = new ThreadRun();
        beCalled.setName("BeCalled");
//        beCalled.run();
        //取值为1~10，缺省为5，但线程的优先级不可靠，不建议作为线程开发时候的手段
        beCalled.setPriority(10);
        beCalled.start();
    }
}
