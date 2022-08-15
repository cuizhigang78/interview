package _20_objectMemoryLayout;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Author Maxwell
 * @Date 2021/4/21 8:27
 * @Description Test
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        heavyLock();
    }

    public static void heavyLock() {
        User user = new User();
        new Thread(() -> {
            synchronized (user) {
                // 010 重量级锁
                System.out.println("--THREAD1--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (user) {
                // 010 重量级锁
                System.out.println("--THREAD2--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 升级为轻量级锁
     */
    private static void lightLock() throws InterruptedException {
        User user = new User();
        synchronized (user) {
            // 101 可偏向、无锁
            System.out.println("--MAIN--:" + ClassLayout.parseInstance(user).toPrintable());
        }

        Thread thread = new Thread(() -> {
            synchronized (user) {
                // 000 不可偏向、轻量级锁
                System.out.println("--THREAD--:" + ClassLayout.parseInstance(user).toPrintable());
            }
        });
        thread.start();
        thread.join();
        // 001 不可偏向、无锁
        System.out.println("--END--:" + ClassLayout.parseInstance(user).toPrintable());
    }

    /**
     * 升级为偏向锁
     */
    private static void biasedLock() {
        User user = new User();
        synchronized (user) {
            // 101 可偏向、无锁
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
        // 101 可偏向、无锁
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        synchronized (user) {
            // 101 可偏向、无锁
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
    }

    /**
     * 对象刚创建时的无锁状态
     */
    private static void noLock() {
        User user = new User();
        // 001 不可偏向、无锁
        // -XX:BiasedLockingStartupDelay=0 101 可偏向、无锁
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }

    private static void printVMDetails() {
        /**
         * # Running 64-bit HotSpot VM.
         * # Using compressed oop with 3-bit shift.
         * # Using compressed klass with 3-bit shift.
         * # Objects are 8 bytes aligned.
         */
        System.out.println(VM.current().details());
    }

}
