package _16_reference;

/**
 * create by 崔 on 2020/4/19
 *
 * 强引用：指向new关键字创建的对象的引用。
 * 当JVM内存空间不足时，JVM宁愿抛出OOM，使程序异常终止，也不会靠随意回收具有强引用的“存活”对象来解决内存不足的问题。
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        // 这样定义默认就是强引用
        Object obj1 = new Object();
        // 赋值
        Object obj2 = obj1;
        // 置空
        obj1 = null;
        System.gc();
        System.out.println(obj2);
        // java.lang.Object@1540e19d还是存在，说明强引用并不会被垃圾回收
    }
}
