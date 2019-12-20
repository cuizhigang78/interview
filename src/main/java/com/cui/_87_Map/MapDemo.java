package com.cui._87_Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap和HashTable的区别
 * 1. 二者实现了Map接口，但是HashMap继承自AbstractMap，而Hashtable继承自Dictionary；
 * 2. HashMap允许null作为键和值，而HashTable的键值均不能为null；
 * 3. HashTable使用synchronized进行同步，线程安全，而HashMap是线程不安全的。
 */

/**
 * 为什么HashMap允许null作为键和值，HashTable则不允许？
 * 1. 查看HashMap的源码发现，当key值是null时，返回0
 *    static final int hash(Object key) {
 *         int h;
 *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *     }
 *
 * 2. 查看Hashtable的源码，在459行和464行，键值不能为空的原因一目了然。
 *
 * 3. ConcurrentHashMap和HashTable相同，也不支持null作为键值，在源码的1011行直接抛出了NullPointerException
 */

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Hashtable<String, Object> hashtable = new Hashtable<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        hashMap.put(null, null);
        hashtable.put(null, null);
        concurrentHashMap.put(null, null);
        System.out.println(hashtable);
        System.out.println(hashtable);
    }
}
