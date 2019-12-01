package com.cui._03_container_not_safe;

import java.util.*;

/**
 * 集合类不安全问题
 
 *
 *
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        listNotSafe();
    }

    /**
     * 解决：
     * 1. Vector<T>()
     * 2. Collections.synchronizedList(new ArrayList<T>())
     * 3. new CopyOnWriteArrayList()
     *
     *     CopyOnWrite容器即写时复制容器。向一个容器中添加元素的时候，不直接往当前容器Object[]添加，
     * 而是先将容器Object[]进行copy,复制出一个新的窗口Object[] newElements，然后新的容器Object[] newElements
     * 里添加元素，添加完元素之后，再将原窗口的引用指向新的容器。这样做的好处是可以对CopyOnWrite容器进行并发的读，
     * 而不需要加锁。因为当前容器不会添加任何元素。所以CopyOnWrite容器也量种读写分离思想的体现，读和写不同的窗口。
     */
    private static void listNotSafe() {
        List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new CopyOnWriteArrayList<>();

        // ConcurrentModificationException
        // 这里不调用toString()就不会报错，原因是toString()会遍历集合，而
        // 遍历集合里如果对集合进行“结构性”修改，就会抛出fail- fast

        // ArrayIndexOutOfBoundsException
        // 这里在插入线程都结束后，调用size()方法，发现集合大小并不是预期大小，
        // 且偶尔会出现数组越界。
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                for (int j = 0; j < 300; j++) {
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                }
                //System.out.println(list);
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(list.size());
    }
}
