package _17_SOFE_OOM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * create by 携山超 on 2020/4/25
 *
 *
 */
public class MetaSpaceOOMDemo {
    // Java8及之后的版本使用Metaspace来替代永久代
    // Metaspace是方法区在HotSpot中的实现，它与持久代最大区别在于：Metaspace并在虚拟内存中，而是在本地内存中。
    // 也即在Java8中，classes metadata(the virtual machines internal presentation of Java class)，被存储
    // 在叫做Metaspace的native memory。

    // 永久代（Java8及以后被元空间取代）存放了以下信息：
    // 1. 虚拟机加载的类信息
    // 2. 常量池
    // 3. 静态变量
    // 4. 即时编译后的代码

    // 模拟Metaspace内存溢出，需要不断生成类往无空间放
    // -XX:MaxMetaspaceSize=10m
    static class OOMTest {}
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable t) {
            System.out.println("*******多少次后发生了异常：" + i);
            t.printStackTrace();
            // Caused by: java.lang.OutOfMemoryError: Metaspace
        }
    }
}
