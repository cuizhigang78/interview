package _05_lock;

/**
 *     独占锁：指该锁一次只能被一个线程所持有。对ReentrantLock和Synchronized而言都是独占锁
 *
 *     共享锁：指该锁可被多个线程所持有。对ReentrantReadWriteLock而言，其读锁是共享锁，
 * 写锁是独占锁。读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。
 *
 */

import _99_common.entity.Cache;


/**
 *     多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行，
 * 但是，如果有一个线程想去写共享资源，就不应该再有其他线程可以同时对该资源进行读或写了。
 *     读-读 能共存
 *     读-写 不能共存
 *     写-写 不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Cache cache = new Cache();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                cache.set(String.valueOf(i), i);
            }
        }, "set").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                cache.get(String.valueOf(i));
            }
        }, "get").start();
    }
}




















