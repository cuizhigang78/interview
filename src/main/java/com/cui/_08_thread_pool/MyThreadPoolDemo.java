package com.cui._08_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *     线程池做的工作主要是控制运行线程的数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务。
 * 如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
 *
 * 特点：
 * 1. 线程复用
 * 2. 控制最大并发数
 * 3. 管理线程
 *
 * 优势：
 * 1. 降低资源消耗。通过利用利用已创建的线程降低线程创建和销毁造成的消耗。
 * 2. 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
 * 3. 提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，还会降低系统的稳定性，
 * 使用线程可以进行统一的分配、调优和监控。
 *
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());

        /**
         * 一池固定数线程，用于执行长期任务
         * 主要特点：
         * 1. 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * 2. newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue；
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        /**
         * 一池一线程，用于一个任务一个任务执行的场景
         * 主要特点：
         * 1. 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行。
         * 2. newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，它使用LinkedBlockingQueue；
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 一池多线程，用于执行很多短期异步的小程序或者负载较轻的服务器
         * 主要特点：
         * 1. 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         * 2. newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，使
         * 用SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * int corePoolSize：线程池中的常驻核心线程数，此值必须大于等于0；
         * int maximumPoolSize：线程池能够同时容纳的最大线程数，此值必须大于等于1；
         * long keepAliveTime：空闲线程的存活时间。当前线程池线程数量超过corePoolSize，且空闲时间达到keepAliveTime值时，
         *                     多余空闲线程会被销毁直到剩下corePoolSize个线程为止；
         * TimeUnit unit：keepAliveTime的单位；
         * BlockingQueue<Runnable> workQueue：任务队列，被提交但尚未被执行的任务；
         * ThreadFactory threadFactory：生成线程池中工作线程的线程工厂，用于创建线程，一般默认即可；
         * RejectedExecutionHandler handler：拒绝策略，当队列满了并且工作线程大于等于线程池最大线程数时如何拒绝请求执行的runnable策略。
         */

        /**
         * 1. 在创建了线程池后，等待提交过来的任务请求
         * 2. 当调用execute()方法添加一个请求任务时，线程池会做如下判断：
         *     1）如果正在运行的线程数量小于corePoolSize，就创建线程运行这个任务；
         *     2）如果正在运行的线程数量大于或等于corePoolSize，就将这个任务放入队列等待；
         *     3）如果这时候队列满了且正在运行的线程数量小于maximumPoolSize，就创建非核心线程运行任务；
         *     4）如果队列满了且正在运行的线程数量大于或等于maximumPoolSize，那么线程池会启动饱和拒绝策略来执行拒绝。
         * 3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。
         * 4. 当一个线程无事可做超过一定的时间（keepAliveTime）时，线程池会判断当前运行的线程数是否大于corePoolSize，
         *     如果大于，那么这个线程就被停掉。所以线程池的所有任务完成后它最终会收缩到corePoolSize大小。
         */
    }
}



















