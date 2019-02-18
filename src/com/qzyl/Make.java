package com.qzyl;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 生产车的类
 */
public class Make implements Runnable{
    //封装当前类
    private static Make make;

    public Make() {
    }

    public static Make getMake(){
        if(make==null){
            make=new Make();
        }
        return make;
    }

    //库存实例
    public ConcurrentLinkedQueue<Cycle> cycleCache=new ConcurrentLinkedQueue<>();
    //生产方法
    public void makeCycle(){
        try {
            while (true){
                Thread.sleep(2000);
                Cycle cycle=CycleFactory.getCycle();
                cycleCache.add(cycle);
                System.out.println(Thread.currentThread().getName()+"工厂造了一辆单车"+"=====现在库存有"+cycleCache.size()+"辆车");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        makeCycle();
    }
}
