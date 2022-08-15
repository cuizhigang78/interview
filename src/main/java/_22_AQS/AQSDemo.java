package _22_AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AQSDemo
 * @Author Maxwell
 * @Date 2021/8/26 22:02
 * @Description AQSDemo
 * @Version 1.0
 */
public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        // 带入一个银行办理业务的案例来模拟我们的 AQS 如何进行线程的管理和通知唤醒机制
        // 3个线程模拟3个银行网点，受理窗口办理业务的顾客
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " thread come in");
             try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " thread come in");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " thread come in");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}

