package com.cui._99_common.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        add();
    }

    private void add() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tadd() invoked");
            minus();
        } finally {
            lock.unlock();
        }
    }

    private void minus() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tminus() invoked");
        } finally {
            lock.unlock();
        }
    }
}
