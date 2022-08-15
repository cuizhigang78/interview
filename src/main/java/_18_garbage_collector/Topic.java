package _18_garbage_collector;

/**
 * create by 携山超 on 2020/4/25
 *
 * 4种主要垃圾收集器
 *
 * 串行垃圾回收器(Serial)，为单线程环境设计，只使用一个线程进行垃圾回收，会暂停所有的用户线程。不适合服务器环境。
 *
 * 并行垃圾回收器(Parallel)，多个垃圾收集线程并行工作，会暂停所有用户线程，适用于科学计算/大数据处理首台处理等弱交互场景。
 *
 * 并发垃圾回收器(CMS(concurrent mark sweep))，用户线程和垃圾收集线程同时执行（不一定是并行，可能交替执行），不需要停顿用户线程。
 * 多用于互联网公司，适用于对响应时间有要求的场景。
 *
 * G1垃圾回收器(garbage first)，将堆内存分割成不同的区域然后并发地进行垃圾回收。
 */
public class Topic {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
        // java -XX:+PrintCommandLineFlags -version
        // -XX:InitialHeapSize=267345088
        // -XX:MaxHeapSize=4277521408
        // -XX:+PrintCommandLineFlags
        // -XX:+UseCompressedClassPointers
        // -XX:+UseCompressedOops
        // -XX:-UseLargePagesIndividualAllocation
        // -XX:+UseParallelGC 默认使用并行垃圾回收器

        // UseSerialGC
        // UseSerialOldGC (已废弃)
        // UseParallelGC
        // UseConcMarkSweepGC
        // UseParNewGC
        // UseParallelOldGC
        // UseG1GC

    }
}
