package _05_lock;

import _99_common.entity.Calculator;
import _99_common.entity.Phone;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁（也叫递归锁）
 *
 * 同一个线程在外层方法获取锁之后，进入内层方法时会自动获取锁（前提是锁对象是同一个）。
 * 不会因为之前已经获取过锁还没有释放而阻塞。
 *
 * 可重入锁的最大作用，就是防止死锁
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
