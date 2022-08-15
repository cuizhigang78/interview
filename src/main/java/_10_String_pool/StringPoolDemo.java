package _10_String_pool;

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
 * 2. String::inter()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用；
 *    否则，会将此String对象包含的字符串添加到常量池中，并返回此String对象的引用。
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
        String s5 = "a";
        String s6 = "b";
        String s7 = "c";
        String s8 = s5 + s6 + s7;
        System.out.println(s == s4);  // true
        System.out.println(s == s8);  // false

        String str1 = new StringBuilder("58").append("tongcheng").toString(); // 堆内存
        System.out.println(str1 == str1.intern()); // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern()); // false
    }
}
