package com.qzyl;

/**
 * 运行线程
 */
public class Sell {
    public static void main(String[] args) throws InterruptedException {
        Make make=Make.getMake();
        CycleStore store=new CycleStore();
        Thread makeThread=new Thread(make);
        Thread storeThread=new Thread(store);
        makeThread.start();
        Thread.sleep(8000);
        System.out.println("商店开始卖车了");
        storeThread.start();
    }
}
