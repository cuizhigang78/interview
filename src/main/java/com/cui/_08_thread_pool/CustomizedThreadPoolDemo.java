package com.cui._08_thread_pool;

import java.util.concurrent.*;

/**
 * 自定义线程池
 *
 * 1. CPU密集型
 *     CPU密集型的意思是该任务需要大量的运算且没有阻塞，CPU一直全速运行。
 *     CPU密集型任务只有在真正多核CPU上才可能得到加速（能过多线程）
 *     CPU密集型任务配置尽可能少的线程数量，一般公式：CPU核数 + 1 个线程数量的线程池
 *
 * 2. IO密集型
 *     IO密集型，即该任务需要大量的IO，即大量的阻塞。
 *     在单线程上运行IO密集型的任务会导致浪费大量的CPU运算能力在等待上，所以使用多线程可以大大地
 * 加速程序运行，即使在单核CPU上，这种加速主要就是利用了被浪费掉的阻塞时间。
 *     IO密集型任务需要多配置线程数：参考公式：CPU核数 / 1 - 阻塞系数
 *
 */
public class CustomizedThreadPoolDemo {

    public static void main(String[] args) {

    }

    private static void discardPolicy() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 0; i < 18; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\tcome in...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void discardOldestPolicy() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 0; i < 18; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\tcome in...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void callerRunsPolicy() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        try {
            for (int i = 0; i < 18; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\tcome in...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void abortPolicy() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        try {
            for (int i = 0; i < 8; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\tcome in...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
