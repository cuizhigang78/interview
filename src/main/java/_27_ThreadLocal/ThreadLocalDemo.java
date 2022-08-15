package _27_ThreadLocal;

/**
 * 阿里面试题：
 *     Spring如何处理Bean在多线程下的并发安全问题？
 * 在Spring中，我们使用模板类访问底层数据，虽然模板类通过资源池获取数据连接或会话，但资源池本身解决的是数据连接
 * 或会话的缓存问题，并非数据连接或会话的线程安全问题。
 *
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println(threadLocal.get()); // null
            threadLocal.set(0);
            System.out.println(threadLocal.get()); // 0
        });

        Thread t2 = new Thread(() -> {
            System.out.println(threadLocal.get()); // null
            threadLocal.set(1);
            System.out.println(threadLocal.get()); // 1
        });

        t1.start();
        t1.join();
        t2.start();
        /*
        由运行结果可以得出：threadLocal变量是线程隔离的。
         */
    }
}
























