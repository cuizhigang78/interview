package _24_proxy.cglib;

import _24_proxy.jdk.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName Client
 * @Author Maxwell
 * @Date 2021/9/2 8:32
 * @Description Client
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {

        Producer producer = new Producer();

        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                String methodName = method.getName();
                float price = (float)args[0];
                if ("sell".equals(methodName)) {
                    return method.invoke(producer, price * 0.8f);
                }
                return method.invoke(producer, price);
            }
        });

        proxyProducer.sell(1000f);
        proxyProducer.afterSell(200f);
    }
}
