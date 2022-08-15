package _87_Map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap的4种遍历方式
 */
public class HashMapTraversal {
    public static void main(String[] args) {
        HashMapTraversal traversal = new HashMapTraversal();
        Map<String,String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");
        
        //traversal.keySetMethod(map);
        //traversal.entrySetMethod(map);
        //traversal.valueMethod(map);
        traversal.iteratorMethod(map);
    }

    // 第一种，通过keySet，二次遍历（先遍历key，再通过key找value）
    public void keySetMethod(Map<String, String> map) {
        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
    }
    
    // 第二种，通过entrySet,效率较高，推荐使用
    public void entrySetMethod(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    
    // 第三种，通过value()，无法得到key
    public void valueMethod(Map<String, String> map) {
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    // 第四种，通过iterator，使用Map.Entry的迭代器，而不是Map.keySet()，原因同第二种
    public void iteratorMethod(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
