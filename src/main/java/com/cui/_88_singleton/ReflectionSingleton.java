package com.cui._88_singleton;

import java.lang.reflect.Constructor;

/**
 * 可以通过反射破坏实例模式。
 * 其实原理很简单，就是通过反射破坏私有的构造方法。通过setAccessible(true)，然后得到newInstance实例。
 * 因为不管是懒汉、饿汉、枚举还是内部类实现的单例模式，总会有私有的构造方法。只要有私有的无参构造方法，就能通过反射得到实例
 *
 * 要想防止反射破坏，可以使用枚举单例来实现
 */
public class ReflectionSingleton {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        Singleton1 singleton2 = Singleton1.INSTANCE;
        Singleton1 singleton3 = null;
        try {
            Constructor[] constructors = Singleton1.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                singleton3 = (Singleton1) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(singleton1.hashCode());  // 1163157884
        System.out.println(singleton2.hashCode());  // 1163157884
        System.out.println(singleton3.hashCode());  // 1956725890
    }
}
