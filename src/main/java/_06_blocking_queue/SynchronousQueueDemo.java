package _06_blocking_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t invoked put() value a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t invoked put() value b");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t invoked put() value c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName() + "\t invoked take() value " + blockingQueue.take());
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName() + "\t invoked take() value " + blockingQueue.take());
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName() + "\t invoked take() value " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
















