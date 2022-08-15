package _13_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(5);
        // 不报错，但结果不对，[1, 1, 2, 2, 3, 3, 4, 5, 5]，原因在于元素被移除了，但是下标却保持不变，
        // 只需在list.remove(i);后加上i--;即可
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 4) {
                list.remove(i);
                i--;
            }
        }*/
        // Exception in thread "main" java.util.ConcurrentModificationException
        /*for (Integer i : list) {
            if (i == 4) {
                list.remove(i);
            }
        }*/

        // 推荐使用，但要注意是 iterator.remove();
        list.removeIf(i -> i.equals(4));
        System.out.println(list);
    }
}
