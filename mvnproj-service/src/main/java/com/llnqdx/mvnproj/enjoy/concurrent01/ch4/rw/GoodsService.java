package com.llnqdx.mvnproj.enjoy.concurrent01.ch4.rw;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:商品的服务的接口
 */
public interface GoodsService {

    public GoodsInfo getNum();//获得商品的信息

    public void setNum(int number);//设置商品的数量
}
