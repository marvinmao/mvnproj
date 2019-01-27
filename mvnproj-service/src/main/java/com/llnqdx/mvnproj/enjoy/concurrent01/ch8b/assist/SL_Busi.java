package com.llnqdx.mvnproj.enjoy.concurrent01.ch8b.assist;

/**
 * @Auther: marvinmao
 * <p>
 * 类说明：用sleep模拟实际的业务操作
 */
public class SL_Busi {

    public static void buisness(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
