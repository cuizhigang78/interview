package _15_JVM_optimization;

/**
 * JVM的参数类型
 *
 * 1. 标配参数：各种Java版本很稳定，很少有大的变化
 *     java -version
 *     java -help
 *     java -showversion
 *
 * 2. X参数（了解）：
 *     java -Xint -version，解释执行 Java HotSpot(TM) 64-Bit Server VM (build 25.31-b07, interpreted mode)
 *     java -Xcomp -version，第一次使用就编译成本地代码 Java HotSpot(TM) 64-Bit Server VM (build 25.31-b07, compiled mode)
 *     java -Xmixed -version，混合模式 Java HotSpot(TM) 64-Bit Server VM (build 25.31-b07, mixed mode)
 *
 * 3. XX参数：
 *     boolean类型 公式： -XX:+或者-某个属性
 *                       +表示开启
 *                       -表示关闭
 *     kv设值类型 公式： -XX:属性key=属性value
 *                      -XX:MetaspaceSize=128m
 *                      -XX:MaxTenuringThreshold=15
 */
public class JVMOptimization {
    public static void main(String[] args) throws InterruptedException {
        // jps 查看正在运行的Java进程
        // jinfo 查看正在运行的Java程序的扩展参数
        // jstack 堆栈跟踪工具
        System.out.println("**** hello JVMOptimization ****");
        // 首先使用jps命令，查看所有正在运行的Java进程及其pid
        // 再通过jinfo -flag PrintGCDetails pid命令查看该线程是否开启了PrintGCDetails属性（PrintGCDetails属性可以是其他任何属性）
        // 也可以通过jinfo -flags pid命令查看该线程的所有属性
        Thread.sleep(Integer.MAX_VALUE);
        // -Xms: -XX:InitialHeapSize  最大堆内存，默认是机器内存的1/4
        // -Xmx: -XX:MaxHeapSize  初始化堆内存，默认是机器内存的1/64
        // java -XX:+PrintFlagsInitial 所有属性初始默认值
        // java -XX:+PrintFlagsFinal 所有属性最初默认值
        // 上述二者输出的结果，=代表值未被修改过 :=代表值被修改过
        // java -XX:+PrintCommandLineFlags 打印命令行参数
    }

}
