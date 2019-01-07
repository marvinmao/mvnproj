package com.llnqdx.mvnproj.enjoy.ch1.wn;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/7
 * @Description:
 */
public class OnlyMain {
    public static void main(String[] args) {
        //虚拟机线程管理的接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
