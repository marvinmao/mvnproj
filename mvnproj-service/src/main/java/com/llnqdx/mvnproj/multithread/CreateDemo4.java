package com.llnqdx.mvnproj.multithread;

import java.util.concurrent.*;

import static com.llnqdx.mvnproj.multithread.CreateDemo.getCurThreadName;
import static com.llnqdx.mvnproj.multithread.SalesDemo.sleepMilliSeconds;
import static com.llnqdx.mvnproj.multithread.SalesDemo.sleepSeconds;

public class CreateDemo4 {
    public static final int MAX_TURN = 5;
    public static final int COMPUTE_TIMES = 100000000;
    //创建一个包含三个线程的线程池
    private static ExecutorService pool = Executors.newFixedThreadPool(3);

    static class DemoThread implements Runnable {
        @Override
        public void run() {
            for (int j = 1; j < MAX_TURN; j++) {
                System.out.println(getCurThreadName() + ", 轮次：" + j);
                sleepMilliSeconds(10);
            }
        }
    }

    static class ReturnableTask implements Callable<Long> {
        //返回并发执行的时间
        public Long call() throws Exception {
            long startTime = System.currentTimeMillis();
            System.out.println(getCurThreadName() + " 线程运行开始.");
            for (int j = 1; j < MAX_TURN; j++) {
                System.out.println(getCurThreadName() + ", 轮次：" + j);
                sleepMilliSeconds(10);
            }
            long used = System.currentTimeMillis() - startTime;
            System.out.println(getCurThreadName() + " 线程运行结束.");
            return used;
        }
    }

    public static void main(String[] args) {
        pool.execute(new DemoThread()); //执行线程实例，无返回
        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int j = 1; j < MAX_TURN; j++) {
                    System.out.println(getCurThreadName() + ", 轮次：" + j);
                    sleepMilliSeconds(10);
                }
            }
        });
        //提交Callable 执行目标实例，有返回
        Future future = pool.submit(new ReturnableTask());
        Long result = null;
        try {
            result = (Long) future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("异步任务的执行结果为：" + result);
        sleepSeconds(5);
    }
}