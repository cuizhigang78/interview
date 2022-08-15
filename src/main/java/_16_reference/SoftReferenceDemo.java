package _16_reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 软引用：通过SoftReference类实现，软引用的生命周期比强引用短一些。
 * 只有当JVM认为内存不足时，才会试图回收软引用指向的对象：即JVM会确保抛出OOM之前，清理软引用指向的对象。
 * 常用作缓存
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        //softRefMemoryEnough();
        softRefMemoryNotEnough();
    }

    /**
     * 内存足够
     */
    public static void softRefMemoryEnough() {
        Object o1 = new Object();  // o1为强引用
        SoftReference<Object> o2 = new SoftReference<>(o1);  // o2为软引用
        System.out.println(o1);  //  java.lang.Object@1540e19d
        System.out.println(o2.get());  // 使用get()  java.lang.Object@1540e19d
        o1 = null;
        System.gc();
        System.out.println(o1);  //  null
        System.out.println(o2.get());  //  java.lang.Object@1540e19d
        // System.gc()后o2.get()保持不变，此时内存充足，软引用并没有被回收

        Map<String, SoftReference<Object>> imageCache = new HashMap<>();
    }

    /**
     * 内存不足
     */
    public static void softRefMemoryNotEnough() {
        Object o1 = new Object();  // o1为强引用
        SoftReference<Object> o2 = new SoftReference<>(o1);  // o2为软引用
        System.out.println(o1);  //  java.lang.Object@1540e19d
        System.out.println(o2.get());  // 使用get()  java.lang.Object@1540e19d
        // JVM配置，配置小内存并产生大对象，人为导致OOM，查看软引用的回收情况
        // -Xms10m -Xmx10m -XX:+PrintGCDetails
        o1 = null;
        try {
            // 产生一个20m的对象
            byte[] bigObj = new byte[20*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);  //  null
            System.out.println(o2.get());  //  null
            // System.gc()后o2.get()也是null，说明在产生大对象后，在系统gc的过程中，软引用对象遭到了清除
        }
    }
}
