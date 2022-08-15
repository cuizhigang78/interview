package _16_reference;

import java.lang.ref.WeakReference;

/**
 *
 * 弱引用：通过WeakReference类实现。弱引用的生命周期比软引用短。
 * 在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。
 * 由于垃圾回收器是一个优先级很低的线程，因此不一定会很快回收弱引用对象。
 * 弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，JVM就会把这个弱引用加入到引用队列中。
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();  // o1为强引用
        WeakReference o2 = new WeakReference(o1);  // o2为弱引用
        System.out.println(o1);  // java.lang.Object@1540e19d
        System.out.println(o2.get());  // java.lang.Object@1540e19d

        o1 = null;
        System.gc();

        System.out.println(o1);  // null
        System.out.println(o2.get());  // null
        // gc回收后，此时内存空间足够，o2仍然被回收，说明只要是存在gc，弱引用就会被回收
    }
}
