package com.llnqdx.mvnproj.enjoy.concurrent01.marvinmao;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 用Runnable与Callable接口的方式创建多线程的特点：
 * 线程类只是实现了Runnable接口或Callable接口，还可以继承其它类。
 * 在这种方式下，多个线程可以共享一个target对象，所以非常适合多个线程来处理同一份资源情况。
 * 如果需要访问当前线程，需要使用Thread.currentThread方法。
 * Callable接口与Runnable接口相比，只是Callable接口可以返回值而已。
 * 用Thread类的方式创建多线程的特点：
 * <p>
 * 因为线程已经继承Thread类，所以不可以再继承其它类。
 * 如果需要访问当前线程，直接使用this即可。
 * @author: marvinmao
 * @Date: 2019-4-21
 */
public class ThreadByCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("current thread:" + Thread.currentThread().getName());

        int i = 0;
        for (; i < 3; i++) {
            System.out.println("i:" + i);
        }
        return i;
    }

    public static void main(String[] args) {
        ThreadByCallable threadByCallable = new ThreadByCallable();

        FutureTask<Integer> futureTask = new FutureTask<>(threadByCallable);
        new Thread(futureTask, "has return thread").start();

        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
