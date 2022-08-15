package _98_reflect;

class MyData {
    static private int i = 1;
    private int j = 2;

    static {
        System.out.println("i被初始化,此时i=" + i);
        i = 6;
        System.out.println("执行静态代码块,此时i=" + i);
    }

    public MyData() {
        System.out.println("无参构造");
    }

    public MyData(int j) {
        System.out.println("构造方法");
        this.j = j;
    }
}

/**
 * 1. Class.forName(String name)本质，就是使用ClassLoader.getSystemClassLoader().loadClass(String name)来将
 *     .class文件加载到jvm中；
 * 2. Class.forName(String name)还有一个重载的方法forName(String name, boolean initialize, ClassLoader loader)，
 *     这里的boolean initialize（默认true） 表示是否初始类，这也是Class.forName()和ClassLoader.getSystemClassLoader().loadClass()的区别；
 * 3. Class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行初始化（参考_89_init），
 *     执行静态类变量显示赋值代码和静态代码块；
 * 4. classLoader只是将.class文件加载到jvm中，不会初始化类,只有在调用newInstance()方法时才会初始化。
 *
 * 需要注意的是：
 * 1. 类只会被初始化一次；
 * 2. newInstance()只能调用无参构造，如果没有无参构造，会出现 java.lang.NoSuchMethodException异常
 */
public class ClassForNameDemo {
    public static void main(String[] args) {
        try {
            //Class.forName("_98_reflect.MyData");

            //ClassLoader.getSystemClassLoader().loadClass("_98_reflect.MyData");

            ClassLoader.getSystemClassLoader().loadClass("_98_reflect.MyData").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * java中new关键字和newInstance()方法的区别
 * 1. new是一个关键字，可以说是一个指令；
 *    newInstance()是一个方法，Class对象的一个方法。
 * 2. new主要作用是在内存中生成一个实例，而这个类可以没有提前加载到内从中；
 *    newInstance()主要作用是在内存中生成一个实例，而这个方法在使用前必须得保证：
 *    ①这个类被加载到JVM中，②这个类已经被连接，而完成以上两个过程的是Class.forName()方法。
 * 3. new关键字会造成强耦合，一般比较呆板的写入到程序中；
 *    newInstance()方法可用于解耦一般用于框架中，工厂模式中等等。
 * 4. new关键字可以调用类的有参的public构造方法；
 *    newInstance()方法只能调用类的无参构造方法。
 */
