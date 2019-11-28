package com.cui._01volatile;

import java.util.concurrent.TimeUnit;


class MyData {
    volatile int num = 0;

    public void addTo60() {
        num = 60;
    }

    public void addPlusPlus() {
        num++;
    }
}
public class VolatileDemo {

    public static void main(String[] args) {
        /**
         * 2. 验证volatile的原子性
         *     2.1 什么是原子性？
         *         不可分割性，完整性。也即某个线程正在做某个具体业务时，中间不能被加塞或者分割。
         *     需要整体完整要么同时成功，要么同时失败。
         *
         */
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            System.out.println("当前活动线程数：" + Thread.activeCount());
            Thread.yield();
        }
        System.out.println("num的值是：" + myData.num);
    }

    /**
     * 1. 验证volatile的可见性
     * volatile修改的变量被修改时，及时通知其他线程，主物理内存的值已经被修改。
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "修改了num，num的值现在是：" + myData.num);
        }, "AAA").start();

        while (myData.num == 0) {
            //System.out.println("main看不见num的值变了，就一直在这转");
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "mission over");
    }
}
