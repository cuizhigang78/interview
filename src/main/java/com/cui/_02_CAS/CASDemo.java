package com.cui._02_CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS全称Compare-And-Swap，它是一条CPU并发原语。
 * 功能是判断内存某个位置的值是否为预期值，如果是则更改为新的值，这个过程是原子的。
 *
 * CAS并发原语体现在JAVA语言中就是sun.misc.Unsafe类中的各个方法。调用Unsafe类中的各个方法，JVM会帮我们实现出CAS汇编指令。
 * 这是一种完全依赖于硬件的功能，通过它实现了原子操作。再次强调，由于CAS是一种系统原语，原语属于操作系统用语范畴，
 * 是由若干条指令组成的，用于完成某个功能的一个过程，并且原语的执行必须是连续的，在执行过程中不允许被中断，
 * 也就是说CAS是一条CPU的原子指令，不会造成所谓的数据不一致问题。
 *
 * Unsafe类
 * CAS的核心类，由于Java方法无法直接访问底层系统，需要通过本地（native）方法来访问，Unsafe相当于一个后门，
 * 基于该类可以直接操作特定内存的数据。Unsafe类存在于sun.misc包中，其内部方法操作可以像C的指针一样直接操作内存，
 * 因为Java中CAS操作的执行依赖于Unsafe类方法。
 * 注意：Unsafe类中的所有方法都是以native修饰的，也就是说Unsafe类中的方法都直接调用操作系统底层资源执行相应任务。
 *
 * 缺点：
 * 1. 循环（自旋）时间长开销很大
 * 2. 只能保证一个共享变量的原子操作
 * 3. 引出来ABA问题
 *
 * ABA：
 * CAS算法实现一个重要前提需要取出内存中某时刻的数据并在当下时刻比较并替换，那么在这个时间关内会导致数据的变化。
 * 比如说一个线程one从内存位置V中取出A，这时候另一个线程tow也从内存中取出A，并且线程two进行了一些操作，
 * 将值变成了B，然后线程two又将V位置的数据变成A，这时候线程one进行CAS操作发现内存中仍然是A，操作成功。
 *
 * 尽管线程one的CAS操作成功，但是不代表这个过程就是没有问题的。
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 10) + "\t当前atomicInteger的值为" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(10, 15) + "\t当前atomicInteger的值为" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 20) + "\t当前atomicInteger的值为" + atomicInteger.get());
    }
}
/**
 * 流程梳理：
 * 假设两个线程A、B同是执行getAndAdd操作（分别跑在不同的CPU上）
 * 1. AtomicInteger里面的value原始值为3，即主内存中的AtomicInteger的value为3。根据JMM模型，线程A和线程B各自持有
 *     一个值为3的value的副本分别到各自的工作内存。
 * 2. 线程A通过getIntVolatile(var1, var2)拿到value的值为3，这时线程A被挂起。
 * 3. 线程B也通过getIntVolatile(var1, var2)拿到value的值3，此时刚好线程B没有被挂起并执行了compareAndSwap方法
 *     比较内存值也为3，成功修改内存值为4，线程B打完收工，一切OK。
 * 4. 这时线程A恢复，执行compareAndSwap方法比较，发现自己手里的值数字3和数字4一一致，说明该值已经被其它线程推行
 *     一步修改过了，那A线程本次修改失败，只能重新读取再来一遍。
 * 5. 线程A重新获取value值，因为变量value被volatile修饰，所以其它线程对它的修改，线程A总是能看到，线程A继续执行
 *     compareAndSwap进行比较替换，直到成功。
 *
 */
















