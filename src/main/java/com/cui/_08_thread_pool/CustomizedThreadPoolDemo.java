package com.cui._08_thread_pool;

import java.util.concurrent.*;

/**
 * 自定义线程池
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
