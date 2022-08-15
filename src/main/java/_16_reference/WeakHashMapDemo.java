package _16_reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * create by 崔 on 2020/4/20
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        //myHashMap();
        myWeakHashMap();
    }

    private static void myHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        hashMap.put(key, value);
        System.out.println(hashMap); // {1=HashMap}
        // 置空key
        key = null;
        System.out.println(hashMap); // {1=HashMap}
        // 手动GC
        System.gc();
        System.out.println(hashMap); // {1=HashMap}
        // 对于HashMap而言，key对象的存在与否，并不影响hashMap对象
    }


    private static void myWeakHashMap() {
        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap); // {2=WeakHashMap}
        // 置空key
        key = new Integer(3);
        System.out.println(weakHashMap); // {2=WeakHashMap}
        // 手动GC
        System.gc();
        System.out.println(weakHashMap); // null
        // 在key被置空且经过一次GC后，WeakHashMap里key指向的entry也被移除了
    }
}
