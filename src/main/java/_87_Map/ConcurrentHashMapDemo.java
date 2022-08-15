package _87_Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        // map.put(null, null);
        // java.lang.NullPointerException
        for (int i = 0; i < 1000; i++) {
            map.put(i, "java" + i);
        }
        /**
         * static final int spread(int h) {
         * 	   return (h ^ (h >>> 16)) & HASH_BITS;
         * }
         */
    }
}
