package com.llnqdx.multithread;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: llnqdx
 * @Date: 2018/11/6
 * @Description:
 */
public class SynchronizedDemo {

    static Object lock = new Object();

    public synchronized void test() {

    }

    public static void main(String[] args) {
        synchronized (lock) {

        }
    }
}
