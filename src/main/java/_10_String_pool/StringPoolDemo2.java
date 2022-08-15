package _10_String_pool;

/**
 * 1 String s = "hello";
 * 2 s += " world!";
 * 执行完这段代码后，原始的String对象中的内容到底变了没有？
 */
public class StringPoolDemo2 {
    public static void main(String[] args) {
        String s = "hello";
        String b = "hello";
        System.out.println(s.equals(b));
        System.out.println(s == b);
        s += " world!";
        System.out.println(s);
        System.out.println(b);
        /**
         * 没有。
         * String被设计成不可变（immutable）类，所以它的所有对象都是不可变对象。此例中，
         * 程序运行到第1行代码时，s指向一个String对象，内容是“hello”，然后对s进行“+”操
         * 作，这时，s不再指向原来的那个对象，而是指向了另一个内容为“hello world!”的对
         * 象，原来那个对象还是存在于内存之中，只是s这个变量的引用不再指向它的。
         *
         */
        // 线程安全
        StringBuffer stringBuffer;
        // 线程不安全
        StringBuilder stringBuilder;
    }
}
