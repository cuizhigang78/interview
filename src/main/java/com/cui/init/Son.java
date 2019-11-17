package com.cui.init;

/**
 * 1. 一个类要创建实例需要先加载并初始化该类
 *     1）main方法所在的类需要先加载和初始化
 * 2. 一个子类要初始化，需要先初始化父类
 * 3. 一个类初始化就是执行<clinit>()方法
 *     1）<clinit>()方法由静态类变量显示赋值代码和静态代码块组成
 *     2）类变量显示赋值代码和静态代码块代码从上到下按顺序执行，
 *        而对应的构造器的代码最后执行
 *     3）<clinit>()方法只执行一次
 * 4. 实例初始化就执行<init>()方法
 *     1）<init>()方法可能有多个重载，有几个构造器就有几个<init>()方法
 *     2）<init>()方法由非静态实例变量显示赋值代码和非静态代码块、对应构造器代码组成
 *     3）非静态实例变量显示赋值代码和非静态代码块代码从上到下顺序执行，而对应的构造器的代码最后执行
 *     4）每次创建实例对象，调用对应构造器，执行的就是对应的<init>()方法
 *     5）<init>()方法的首行是super()或super(实参列表)，即对应父类的<init>()方法
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6)");
    }

    Son() {
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son1 = new Son();
        System.out.println();
        Son son2 = new Son();
    }
}














