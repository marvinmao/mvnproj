package com.llnqdx.mvnproj.enjoy.concurrent01.ch6.comps;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:任务类
 */
public class WorkTask implements Callable<Integer> {
    private String name;

    public WorkTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        int sleepTime = new Random().nextInt(1000);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 返回给调用者的值
        return sleepTime;
    }
}
