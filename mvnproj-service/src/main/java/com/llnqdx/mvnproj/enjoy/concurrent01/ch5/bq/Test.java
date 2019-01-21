package com.llnqdx.mvnproj.enjoy.concurrent01.ch5.bq;

import java.util.concurrent.DelayQueue;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:测试延时订单
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        DelayQueue<ItemVo<Order>> queue = new DelayQueue<>();

        new Thread(new PutOrder(queue)).start();
        new Thread(new FetchOrder(queue)).start();

        //每隔500毫秒，打印个数字
        for (int i = 1; i < 15; i++) {
            Thread.sleep(500);
            System.out.println(i * 500);
        }
    }
}
