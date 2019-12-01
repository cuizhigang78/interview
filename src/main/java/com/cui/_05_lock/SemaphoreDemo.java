package com.cui._05_lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯
 *     主要用于两个目的：
 * 1. 多个共享资源的互斥使用
 * 2. 并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 三个车位
        Semaphore semaphore = new Semaphore(3);
        // 六辆车来抢
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t停了3秒后离开...车位暂时空闲。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
