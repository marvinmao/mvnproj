package com.llnqdx.mvnproj.multithread;

import java.util.concurrent.atomic.AtomicInteger;

import static com.llnqdx.mvnproj.multithread.CreateDemo.getCurThreadName;

public class SalesDemo {

    public static final int MAX_AMOUNT = 5; //商品数量

    //商店商品类（销售线程类），一个商品一个销售线程，每个线程异步销售4次
    static class StoreGoods extends Thread {
        StoreGoods(String name) {
            super(name);
        }

        private int goodsAmount = MAX_AMOUNT;

        public void run() {
            for (int i = 0; i <= MAX_AMOUNT; i++) {
                if (this.goodsAmount > 0) {
                    System.out.println(getCurThreadName() + " 卖出一件，还剩："
                            + (--goodsAmount));
                    sleepMilliSeconds(10);
                }
            }
            System.out.println(getCurThreadName() + " 运行结束.");
        }
    }

    //商场商品类（target销售线程的目标类），一个商品最多销售4次，可以多人销售
    static class MallGoods implements Runnable {
        //多人销售可能导致数据出错，使用原子数据类型保障数据安全
        private AtomicInteger goodsAmount = new AtomicInteger(MAX_AMOUNT);

        public void run() {
            for (int i = 0; i <= MAX_AMOUNT; i++) {
                if (this.goodsAmount.get() > 0) {
                    System.out.println(getCurThreadName() + " 卖出一件，还剩："
                            + (goodsAmount.decrementAndGet()));
                    sleepMilliSeconds(10);
                }
            }
            System.out.println(getCurThreadName() + " 运行结束.");
        }
    }

    static void sleepMilliSeconds(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void sleepSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("商店版本的销售");
        for (int i = 1; i <= 2; i++) {
            Thread thread = null;
            thread = new StoreGoods("店员-" + i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println("商场版本的销售");
        MallGoods mallGoods = new MallGoods();
        for (int i = 1; i <= 2; i++) {
            Thread thread = null;
            thread = new Thread(mallGoods, "商场销售员-" + i);
            thread.start();
        }
        System.out.println(getCurThreadName() + " 运行结束.");
    }
}