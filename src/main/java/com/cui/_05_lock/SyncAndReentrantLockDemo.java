package com.cui._05_lock;

/**
 * synchronized和Lock有什么区别？用新的Lock有什么好处？举例说说
 * 1. 原始构成
 *     synchronized是关键字，属于JVM层面；
 *     Lock是具体类（java.util.concurrent.locks.Lock），属于API层面。
 * 2. 使用方法
 *     synchronized不需要用户去手动释放锁，当synchronized代码执行完成后系统会自动让线程释放对锁的占用；
 *     ReentrantLock需要用户去手动释放锁，否则就有可能出现死锁现象。
 * 3. 等待是否可中断
 *     synchronized不可中断，除非抛出异常或者正常运行完成；
 *     ReentrantLock可中断，
 *     1）设置超时方法tryLock(long timeout, TimeUnit unit)
 *     2）lockInterruptibly()放代码块中，调用interrupt()方法可中断
 * 4. 加锁是否公平
 *     synchronized非公平锁
 *     ReentrantLock两者都可以，默认公平锁。构造方法可以传入boolean值，true为公平锁，false为非公平锁。
 * 5. 锁绑定多个条件Condition
 *    synchronized没有
 *    ReentrantLock用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized要么随机唤醒，要么唤醒全部。
 *
 */
public class SyncAndReentrantLockDemo {
}
