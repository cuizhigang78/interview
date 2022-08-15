package _87_Map;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HashMap.put()
 * Java7使用头插法：出现循环引用
 *
 * Java8使用尾插法：Node无法强转为TreeNode
 *
 *
 */
public class HashMapPutDemo {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, Object> hashMap = new HashMap<>(2);

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    hashMap.put(UUID.randomUUID().toString(), "");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        // 使用方法join()方法，给t线程插个队，main()线程需等等t执行完成
        t.join();


        /*int a = 3;
        int b = 5;
        System.out.println(a |= b); // 7*/

        /*int cap = tableSizeFor(100);
        System.out.println(cap);
        for (int i = 0; i < 1000 ; i++) {
            System.out.println((cap - 1) & i);
        }*/

        //System.out.println(31 & 9);  //9

        //System.out.println(tableSizeFor(17));
    }

    /**
     * HashMap的容量大小必是2的整数次幂，即使在创建HashMap对象时指定了容量的大小，
     * 也会调用tableSizeFor()方法来获取大于指定容量的最小的2的整数次幂。
     * 这么做的目的是为了能使HashMap中的元素均匀地分布，降低hash碰撞的可能。因为
     * hashMap储存元素时，生成下标的算法是通过（map的容量-1 & hash值），此时，下
     * 标只与hash值有关，从而实现了均匀分布。
     *
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
