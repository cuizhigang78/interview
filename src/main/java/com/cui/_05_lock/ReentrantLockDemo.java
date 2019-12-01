package com.cui._05_lock;

import com.cui._99_common.entity.Calculator;
import com.cui._99_common.entity.Phone;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁（也叫递归锁）
 *     指的是同一线程外层函数获取得锁之后，内层递归函数可以获取该锁，
 * 同一个线程在外层方法获取锁之后，进入内层方法时会自动获取锁。也即是说，
 * 线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 *  // 大门钥匙打开以后，就不用钥匙再打开房间门了
 *
 *     可重入锁的最大作用，就是防止死锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {

        System.out.println("====== synchorized是典型的可重入锁 ======");

        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("====== ReentrantLock是典型的可重入锁 ======");

        Calculator calculator = new Calculator();
        Thread t4 = new Thread(calculator, "t4");
        Thread t5 = new Thread(calculator, "t5");
        t4.start();
        t5.start();
    }
}
