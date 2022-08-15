package _06_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingQueue：是一个基于链表结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序。吞吐量通常要高于ArrayBlockingQueue。
 * SynchronousQueue：是一个不存储元素的阻塞队列，每个插入操作必须待到另一个线程调用移除操作，否则插入操作一起处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue。
 *
 * 当阻塞队列是空的时，从队列中获取元素的操作将会被阻塞；
 * 当阻塞队列是满的时，往队列中添加元素的操作将会被阻塞。
 *
 * 在多线程领域，所谓阻塞，就是指在某些情况下线程会被挂起，等到条件满足时，又会被自动唤醒。
 *
 * 为什么需要BlockingQueue?
 *    可以让我们不再关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切BlockingQueue都
 * 一手包办了。
 *    在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节，尤其还要
 * 兼顾效率和线程安全，这会给我们的程序带来不小的复杂度。
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {

    }

    private static void putTake() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 会阻塞线程，直到队列有空位为止
        //blockingQueue.put("e");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 会阻塞线程，直到队列有元素为止
        //System.out.println(blockingQueue.take());
    }

    /**
     * offer()
     * peek()
     * poll()
     */
    private static void offerPeekPoll() throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // false
        //System.out.println(blockingQueue.offer("e"));
        // 等待两秒再插入
        blockingQueue.offer("e", 2L, TimeUnit.SECONDS);

        // a 如果blockingQueue没有元素，返回null
        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // null
        System.out.println(blockingQueue.poll());
        // 等待两秒再取
        blockingQueue.poll(2L, TimeUnit.SECONDS);
    }

    /**
     * add()
     * element()
     * remove()
     */
    private static void addElementRemove() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("e"));

        // 如果blockingQueue中没有元素，java.util.NoSuchElementException
        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }
}
