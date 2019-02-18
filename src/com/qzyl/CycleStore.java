package com.qzyl;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 单车售卖商店
 */
public class CycleStore implements Runnable{
    private ConcurrentLinkedQueue<Cycle> storeCache = new ConcurrentLinkedQueue<>();
    Random random = new Random();
    @Override
    public void run(){
        while(true){
            if(storeCache.size() == 0){
                getStoreCache();
            }
            sellCycle();
        }
    }
    //得到商店库存的方法
    private void getStoreCache(){
        Make make = Make.getMake();
        ConcurrentLinkedQueue<Cycle> cyclePack = new ConcurrentLinkedQueue<>();
        //根据条件判断得到商店库存
        if(make.cycleCache.size()<5){
            cyclePack = make.cycleCache;
            make.cycleCache = new ConcurrentLinkedQueue<>();
            System.out.println(Thread.currentThread().getName()+"商店把工厂的库存搬光了");
        }else{
            for (int i = 0; i < 5; i++) {
                Cycle removedCycle = make.cycleCache.remove();
                cyclePack.add(removedCycle);
            }
            System.out.println(Thread.currentThread().getName()+"商店从工厂库存中取了五辆单车");
            System.out.println(Thread.currentThread().getName()+"工厂库存还有"+make.cycleCache.size()+"辆");
        }
        storeCache = cyclePack;
    }
    //卖车的方法
    private void sellCycle(){
        int randSecond = random.nextInt(10)+1;
        try {
            Thread.sleep(randSecond*1000);
            storeCache.remove();
            System.out.println(Thread.currentThread().getName()+"商店卖出去了一辆单车");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
