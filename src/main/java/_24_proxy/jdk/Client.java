package _24_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
