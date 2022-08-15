package _21_lock_support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LockSupportDemo {

    static Object objectLock = new Object();

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 进来了");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 被唤醒");
        }, "A");
        a.start();


        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + " 通知");
        }, "B");
        b.start();
    }

    private static void awaitSignal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 进来了");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + " 通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
        /**
         * 同 synchronized
         */
    }

    private static void waitNotify() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + " 进来了");
                try {
                    // 释放锁
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
        }, "A").start();
        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + " 通知");
            }
        }, "B").start();
        /**
         * 1. wait() 和 notify() 方法必须要在同步块或者方法里面成对出现；
         * 2. 必须先 wait() 再 notify();
         */
    }
}
