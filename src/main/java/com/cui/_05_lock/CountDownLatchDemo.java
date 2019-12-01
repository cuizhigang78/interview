package com.cui._05_lock;

import com.cui._99_common.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时器
 *     让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
 *     CountDownLatch主要有两个方法，当一个或多个线程调用await()方法时，调用线程会被阻塞。
 * 其他线程调用countDown方法会将计数器减1（调用countDown方法的线程不会阻塞），当计数器的值
 * 变为零时，因调用await()方法被阻塞的线程会被唤醒，继续执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        lockDoor();
    }

    private static void lockDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"国被灭了...");
                countDownLatch.countDown();
            }, CountryEnum.getCountryEnum(i).getName()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("秦国统一。");
    }
}
