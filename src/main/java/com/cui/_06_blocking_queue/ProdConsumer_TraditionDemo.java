package com.cui._06_blocking_queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始量为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 *
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒（while）
 */
class ShareData {
    public int i = 0;

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void add() throws InterruptedException {
        lock.lock();
        try {
            while(i == 1) {
                condition.await();
            }
            i++;
            condition.signalAll();
            System.out.println("i = " + i + " now!");
        } finally {
            lock.unlock();
        }
    }

    public void minus() throws InterruptedException {
        lock.lock();
        try {
            while(i == 0) {
                condition.await();
            }
            i--;
            condition.signalAll();
            System.out.println("i = " + i + " now!");
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData data = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "add").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.minus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "minus").start();
    }
}
