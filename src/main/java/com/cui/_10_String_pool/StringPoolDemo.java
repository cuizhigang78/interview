package com.cui._10_String_pool;

/**
 * 字符串常量池（String pool）
 * 目的：JVM为了提高性能和减少内存开销，实现数据共享
 *
 * 1. 为字符串开辟一个字符串常量池（存在于方法区）
 * 2. 创建字符串常量时，首先检查字符串常量池是否存在该字符串
 * 3. 如果存在，返回引用实例；如果不存在，实例化该字符串并放入池中。
 *
 * tips:
 * 1. 使用New String()创建的字符串实例将会保存在堆内存而不是常量池中
 * 2. 使用intern()方法，会将新创建的字符串放到常量池中
 */
public class StringPoolDemo {

    public static void main(String[] args) {
        String s1 = "Cat";  // 常量池
        String s2 = "Cat";  // 常量池
        String s3 = new String("Cat");  // 堆

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false

        String s = "abc";
        String s4 = "a" + "b" + "c";
        System.out.println(s == s4);  // true
    }
}
