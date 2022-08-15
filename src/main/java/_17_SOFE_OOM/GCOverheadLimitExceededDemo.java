package _17_SOFE_OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * create by 携山超 on 2020/4/25
 *
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 */
public class GCOverheadLimitExceededDemo {
    public static void main(String[] args) {
        // GC回收时间过长时，会抛出OutOfMemoryError。
        // 过长的定义是：超过98%的时间用来做GC并且回收了不到2%的堆内存。
        // 连续多次GC都只回收不到2%的极端情况下才会抛出。

        // 假如不抛出GC overhead limit错误会发生什么情况呢？
        // 就是GC清理出来的那么点内存就会很快地被再次填满，迫使GC再次执行，形成恶性循环。
        // CPU使用率一直是100%，GC却没有显著效果。
        List<String> list = new ArrayList<>();
        // -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // String.valueOf产生的对象存在堆内存中
            // 使用intern()方法可以将引用指向常量池
            list.add(String.valueOf(i).intern());
        }
        // Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded

        // [Full GC (Ergonomics)
        //     [PSYoungGen: 504K->0K(2560K)]
        //     [ParOldGen: 6202K->6383K(7168K)] 6706K->6383K(9728K), [Metaspace: 2982K->2982K(1056768K)], 0.0322227 secs]
        // [Times: user=0.03 sys=0.03, real=0.03 secs]
        // Ergonomics翻译成中文，一般都是“人体工程学”。
        // 在JVM中的垃圾收集器中的Ergonomics就是负责自动的调解gc暂停时间和吞吐量之间的平衡，然后你的虚拟机性能更好的一种做法。
    }
}
