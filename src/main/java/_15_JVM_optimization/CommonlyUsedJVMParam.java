package _15_JVM_optimization;

import java.lang.ref.Reference;

/**
 * JVM调优的一些常用参数
 */
public class CommonlyUsedJVMParam {
    // 1. -Xms(-XX:InitialHeapSize)，初始堆内存大小，默认为物理内存的1/64
    // 2. -Xms(-XX:MaxHeapSize)，最大堆内存大小，默认为物理内存的1/4
    // 3. -Xss(-XX:ThreadStackSize)，设置单个线程栈的大小，一般默认为512k~1024k
    //     https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html
    // 4. -Xmn(-XX:NewSize )，设置新生代大小
    // 5. -XX:MetaspaceSize，设置元空间大小
    //     元空间的本质和永久代类似，都是对JVM规范中方法区的实现。不过元空间与永久代之间的最大区别在于：
    //     元空间并不在虚拟机中，而是使用本地内存。因此，默认情况下，元空间的大小仅受本地内存限制。
    //     java.lang.OutOfMemoryError: Metaspace 错误的主要原因, 是加载到内存中的class数量太多或者体积太大
    // 6. -XX:PrintGCDetails
    //     [
    //         GC (Allocation Failure) GC类型
    //         [PSYoungGen: 488K->504K(2560K)] Young区GC前后内存占用及总内存大小
    //         792K->808K(9728K) YoungGC前后堆内存使用大小及总大小
    //         , 0.0013357 secs YoungGC耗时
    //     ]
    //     [Times: user=0.00 sys=0.00, real=0.00 secs] YoungGC用户耗时、系统耗时、实际耗时
    //     [
    //         Full GC (Allocation Failure)
    //         [PSYoungGen: 504K->0K(2560K)]
    //         [ParOldGen: 304K->743K(7168K)]
    //         808K->743K(9728K),
    //         [Metaspace: 2979K->2979K(1056768K)],
    //         0.0038209 secs
    //     ]
    //     [Times: user=0.00 sys=0.00, real=0.00 secs]
    //     规律：[名称：GC前内存占用 -> GC后内存占用(该区内存总大小)]
    //     这里的GC类型是“Allocation Failure”也即“内存分配失败”导致的垃圾回收；当我们手动调用System.gc()方法时，GC类型相应的就
    //     变成了“System.gc()”。并且System.gc()方法是会同时触发Young GC和Full GC的。
    //     触发Full GC的三种情况：
    //     （1）调用Sytem.GC()
    //     （2）老年代空间不足时
    //     （3）GC担保失败：
    // 7. -XX:SurvivorRatio 设置新生代中，Eden区和S0/S1区空间的比例
    //     默认 -XX：SurvivorRatio=8，即Eden/S0/S1=8/1/1
    // 8. -XX:NewRatio 配置年轻代与老年代在堆结构的占比
    //     默认 -XX：NewRatio=2，即新生代/老年代=1/2
    // 9. -XX:MaxTenuringThreshold 设置垃圾的最大年龄（tenurie，任期，占用。threshold，临界值）
    //     默认 -XX:MaxTenuringThreshold=15，也即新生代的对象要经过15次GC才会进入老年代
    //     设置为0的话，表示Eden区对象跳过S0直接进入老年代
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello CommonlyUsedJVMParam");
        System.gc();
        //byte[] byteArray = new byte[11*1204*1024];
        //CommonlyUsedJVMParam.class.getClassLoader().getResourceAsStream("img/GC收集日志信息.png");
        //Thread.sleep(Integer.MAX_VALUE);
        Reference reference;
    }
}
