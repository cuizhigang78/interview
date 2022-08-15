package _17_SOFE_OOM;

/**
 * create by 携山超 on 2020/4/25
 *
 * java.lang.OutOfMemoryError: Java heap space
 *
 *      Throwable
 *      Error
 *      VritualMachineError
 *      StackOverflowError
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        // 手动调整JVM堆内存大小为10m -Xms10m -Xmx10m -XX:+PrintGCDetails
        // 创建一个大小为11m对象
        byte[] bytes = new byte[11 * 1024 * 1024];
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
