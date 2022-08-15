package _87_Map;

import _99_common.entity.User;

import java.util.*;

/**
 * HashMap的排序问题
 */
public class HashMapSortDemo {
    public static void main(String[] args) {
        Map<Integer, User> map = new HashMap<>();
        map.put(1, new User("张三", 23));
        map.put(2, new User("李四", 24));
        map.put(3, new User("王五", 25));
        System.out.println(sortHashMap(map));
    }

    public static HashMap<Integer, User> sortHashMap(Map<Integer, User> map) {
        // 首先拿到map的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        // 将set集合转为list集合，为了使用工具类的排序方法
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
        Collections.sort(list, (Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) -> {
            // 根据User的age属性倒序进行排序
            return o2.getValue().getAge() - o1.getValue().getAge();
        });
        // 创建一个新的有序的 LinkedHashMap
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        // 将list中的数据转存至LinkedHashMap中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
