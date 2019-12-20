package com.cui._87_Map;

/**
 * HashMap源码分析
 */

import java.util.HashMap;

/**
 * Java7: Entry[] + 链表
 * Java8: Node[] + 链表 + 红黑树
 *
 * 线性链表：
 *     对于链表的新增，删除等操作（在找到指定操作位置后），仅需要处理结点间的引用即可，时间复杂度为O(1)，而查找操作
 * 需要遍历链表逐一进行比对，复杂度为O(n)。
 *
 */
public class HashMapSourceCode {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        /**
         * 把键hash出来的index值作为下标，获取到Node对象，
         * 再值这个Node对象的key值与要查找的比较，如果相同，
         * 返回，如果不相同，比较node.next()。
         *
         * 这里需要遍历链表，Java7使用for循环，Java8使用do while
         */
        hashMap.get("");
    }
}





















