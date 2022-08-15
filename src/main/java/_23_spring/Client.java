package _23_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Client
 * @Author Maxwell
 * @Date 2021/9/1 8:31
 * @Description Client
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        A a = context.getBean("a", A.class);
        // B b = context.getBean("b", B.class);
    }

}
