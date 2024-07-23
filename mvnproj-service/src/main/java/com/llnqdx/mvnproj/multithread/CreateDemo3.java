package com.llnqdx.mvnproj.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.llnqdx.mvnproj.multithread.CreateDemo.getCurThreadName;

public class CreateDemo3 {
    public static final int MAX_TURN = 5;
    public static final int COMPUTE_TIMES = 100000000;

    //①创建一个 Callable 接口的实现类
    static class ReturnableTask implements Callable<Long> {
        //②编写好异步执行的具体逻辑，可以有返回值
        public Long call() throws Exception {
            long startTime = System.currentTimeMillis();
            System.out.println(getCurThreadName() + " 线程运行开始.");
            Thread.sleep(1000);
            for (int i = 0; i < COMPUTE_TIMES; i++) {
                int j = i * 10000;
            }
            long used = System.currentTimeMillis() - startTime;
            System.out.println(getCurThreadName() + " 线程运行结束.");
            return used;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ReturnableTask task = new ReturnableTask();//③
        FutureTask<Long> futureTask = new FutureTask<Long>(task);//④
        Thread thread = new Thread(futureTask, "returnableThread");//⑤
        thread.start();//⑥
        Thread.sleep(500);
        System.out.println(getCurThreadName() + " 让子弹飞一会儿.");
        System.out.println(getCurThreadName() + " 做一点自己的事情.");
        for (int i = 0; i < COMPUTE_TIMES / 2; i++) {
            int j = i * 10000;
        }
        System.out.println(getCurThreadName() + " 获取并发任务的执行结果.");
        try {
            System.out.println(thread.getName() + "线程占用时间："
                    + futureTask.get());//⑦
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(getCurThreadName() + " 运行结束.");
    }
}