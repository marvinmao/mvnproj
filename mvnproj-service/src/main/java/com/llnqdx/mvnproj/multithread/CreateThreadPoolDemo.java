//package com.llnqdx.mvnproj.multithread;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Description: beforeExecute和afterExecute两个方法在每个任务执行前后被调用，
// *         如果钩子（回调方法）引发异常，内部工作线程可能失败并突然终止。
// */
//public class CreateThreadPoolDemo{
//    @org.junit.Test
//    public void testHooks(){
//        ExecutorService pool = new ThreadPoolExecutor(2, //coreSize
//                4, //最大线程数
//                60,//空闲保活时长
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(2)) //等待队列 {
//        //继承：调度器终止钩子
//        @Override
//        protected void terminated(){
//            Print.tco("调度器已经终止!");
//        }
//        //继承：执行前钩子
//        @Override
//        protected void beforeExecute(Thread t, Runnable target){
//            Print.tco( target +"前钩被执行");
//            //记录开始执行时间
//            startTime.set(System.currentTimeMillis());
//            super.beforeExecute(t, target);
//        }
//        //继承：执行后钩子
//        @Override
//        protected void afterExecute(Runnable target, Throwable t){
//            super.afterExecute(target, t);
//            //计算执行时长
//            long time = (System.currentTimeMillis() - startTime.get()) ;
//            Print.tco( target + " 后钩被执行, 任务执行时长（ms）：" + time);
//            //清空本地变量
//            startTime.remove();
//        }
//    };
//        for (int i = 1; i <= 5; i++){
//        pool.execute(new TargetTask());
//    }
//    //等待10秒
//    sleepSeconds(10);
//        Print.tco("关闭线程池");
//        pool.shutdown();
//}
//// 省略其他
//}