package _86_design_pattern.factory.factoryMethodPattern.normalFactory;

import _86_design_pattern.factory.MailSender;
import _86_design_pattern.factory.Sender;
import _86_design_pattern.factory.SmsSender;

/**
 * 普通工厂模式
 * 建立一个工厂，对实现了同一接口的一些类进行实例的创建
 */
public class SendFactory {
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型！");
            return null;
        }
    }
}
