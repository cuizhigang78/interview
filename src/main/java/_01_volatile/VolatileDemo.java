package _01_volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


class MyData {
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        num = 60;
    }

    public void addPlusPlus() {
        num ++;
    }

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * volatile是JVM提供的轻量级的同步机制
 * 1. 保证可见性
 * 2. 不保证原子性
 * 3. 禁止指令重排
 */
public class VolatileDemo {

    public static void main(String[] args) {
        notAtomicByVolatile();
    }

    private static void noHappensBeforeByVolatile() {
        /**
         * 3. 禁止指令重排
         *
         * 计算机在执行程序时，为了提高性能，编译器和处理器常常会对指令做重排，一般分为以下3种：
         *     源代码 -> 编译器优化的重排 -> 指令并行的重排 -> 内存系统的重排 -> 最终执行的指令
         *     1. 单线程环境下确保程序最终执行结果和代码顺序执行的结果一致
         *     2. 处理器在进行重排序时必须要考虑指令之的数据依赖性
         *     3. 多线程环境中线程交替执行，由编译器优化重排的存在，两个线程中使用的变量能否保证一致性是无法确定的，
         * 结果无法预测。
         *
         * volatile实现禁止指令重排优化，从而避免多线程环境下程序出现乱序执行的现象。
         *
         * 内存屏障（Memory Barrier），亦称内存栅栏，是一个CPU指令，它的作用有两个：
         * 1. 保证特定操作的顺序执行
         * 2. 保证某些变量的内存可见性（利用该特性实现volatile的内存可见性）
         * 由于编译器和处理器能执行指令重排优化。如果在指令间插入一条Memory Barrier则会告诉编译器和CPU，
         * 不管什么指令都不能和这种Memory Barrier指令重排序，也就是说通过插入内存屏障禁止在内存屏障前后的指令执行重排序优化。
         * 内存屏障的另一个作用是强制刷出各种CPU的缓存数据，因此任何CPU上的线程都能读取到这些数据的最新版本。
         * 1. 对volatile变量进行写操作时，会在写操作后加入一条store屏障指令，将工作内存中的共享变量值刷新回到主内存。
         * 2. 对volatile变量进行读操作时，会在读操作前加入一条load屏障指令，从主内存中读取共享量。
         */}

    private static void notAtomicByVolatile() {
        /**
         * 2. 验证volatile不保证原子性
         *     2.1 什么是原子性？
         *         不可分割性，完整性。也即某个线程正在做某个具体业务时，中间不能被加塞或者分割。
         *     需要整体完整要么同时成功，要么同时失败。
         */
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            System.out.println("当前活动线程数：" + Thread.activeCount());
            Thread.yield();
        }
        System.out.println("num的值是：" + myData.num);
        System.out.println("atomicInteger的值是：" + myData.atomicInteger);
    }

    /**
     * 1. 验证volatile的保证可见性
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
