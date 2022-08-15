package _16_reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * create by 携山超 on 2020/4/21
 *
 * 引用队列
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);  // java.lang.Object@1540e19d
        System.out.println(weakReference.get());  // java.lang.Object@1540e19d
        System.out.println(referenceQueue.poll());  // null
        // GC前引用队列中无数据

        System.out.println("===== GC =====");

        o1 = null;
        System.gc();
        Thread.sleep(10000);

        System.out.println(o1);  // null
        System.out.println(weakReference.get());  // null
        System.out.println(referenceQueue.poll());  // java.lang.ref.WeakReference@677327b6
        // GC后引用被追加到引用队列中
    }
}
