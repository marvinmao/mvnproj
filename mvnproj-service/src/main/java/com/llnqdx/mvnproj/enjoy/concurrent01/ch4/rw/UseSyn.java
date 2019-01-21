package com.llnqdx.mvnproj.enjoy.concurrent01.ch4.rw;

import com.llnqdx.mvnproj.enjoy.concurrent01.tools.SleepTools;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:用内置锁来实现商品服务接口
 */
public class UseSyn implements GoodsService {

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() {
        SleepTools.ms(5);
        return this.goodsInfo;
    }

    @Override
    public synchronized void setNum(int number) {
        SleepTools.ms(5);
        goodsInfo.changeNumber(number);

    }

}
