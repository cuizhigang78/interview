package _16_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * create by 崔 on 2020/4/21
 *
 * 虚引用：虚引用也叫幻象引用，通过PhantomReference类来实现。
 * 无法通过虚引用访问对象的任何属性或方法。幻象引用幻象引用仅仅是提供了一种确保对象被finalize以后，做某些事情的机制。
 * 如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
 *
 * 管理直接内存
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1);  // java.lang.Object@1540e19d
        System.out.println(phantomReference.get());  // null
        // 与其他引用不同的是，使用虚引用无法获取到它指向的对象
        System.out.println(referenceQueue.poll());  // null

        System.out.println("===== GC =====");

        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);  // null
        System.out.println(phantomReference.get());  // null
        System.out.println(referenceQueue.poll());  // java.lang.ref.PhantomReference@677327b6
    }
}
