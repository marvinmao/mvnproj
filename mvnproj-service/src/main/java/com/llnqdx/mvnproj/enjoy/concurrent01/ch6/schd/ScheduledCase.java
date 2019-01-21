package com.llnqdx.mvnproj.enjoy.concurrent01.ch6.schd;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:演示ScheduledThreadPoolExecutor的用法
 */
public class ScheduledCase {
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor schedule
                = new ScheduledThreadPoolExecutor(1);

        schedule.scheduleAtFixedRate(new ScheduleWorker(ScheduleWorker.HasException),
                1000, 3000, TimeUnit.MILLISECONDS);
        schedule.scheduleAtFixedRate(new ScheduleWorker(ScheduleWorker.Normal),
                1000, 3000, TimeUnit.MILLISECONDS);

    }
}
