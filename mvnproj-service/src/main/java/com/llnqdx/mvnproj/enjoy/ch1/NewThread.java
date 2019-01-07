package com.llnqdx.mvnproj.enjoy.ch1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:
 */
public class NewThread {
    /**
     * 扩展自Thread类
     */

    /**
     * 实现runnable接口
     * 既然已扩展thread类，为什么还要实现接口？
     * JAVA单继承，却可实现多个接口
     */
    private static class UseRun implements Runnable {
        @Override
        public void run() {
            System.out.println("i am Runnable");
        }
    }

    /**
     * 实现Callable接口，允许有返回值
     */
    private static class UseCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("i am implements Callable");
            return "Callable";
        }
    }

    /**
     * java之间的线程是协作式执行
     * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseRun useRun = new UseRun();
        new Thread(useRun).start();
        Thread thread=new Thread(useRun);
        //如何终止线程？
        //stop()会导致线程不会正确释放资源
        //suspend()容易导致死锁，不会释放资源

        //安全的终止线程方法：
        //interrupt()并不是强行关闭这个线程，只是跟这个线程打个招呼
        //将线程的中断标志位置为true，线程是否中断，由线程本身决定。并非强行关闭
        //isInterrupted() 判定当前线程是否处于中断状态
        boolean interrupted = thread.isInterrupted();
        thread.interrupt();
        //static interrupted()方法会将 中断标志位 改为false

        //通过FutureTask将Callable封装成Runnable
        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        new Thread(futureTask);
        System.out.println(futureTask.get());
    }
}
