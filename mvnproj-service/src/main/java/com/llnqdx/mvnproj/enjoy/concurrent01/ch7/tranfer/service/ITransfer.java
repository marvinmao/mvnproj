package com.llnqdx.mvnproj.enjoy.concurrent01.ch7.tranfer.service;


import com.llnqdx.mvnproj.enjoy.concurrent01.ch7.tranfer.UserAccount;

/**
 * @Auther: marvinmao
 * <p>
 * 类说明：银行转账动作接口
 */
public interface ITransfer {
    /**
     * @param from   转出账户
     * @param to     转入账户
     * @param amount 转账金额
     * @throws InterruptedException
     */
    void transfer(UserAccount from, UserAccount to, int amount)
            throws InterruptedException;
}
