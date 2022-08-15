package _86_design_pattern.factory.factoryMethodPattern.staticFactory;

import _86_design_pattern.factory.MailSender;
import _86_design_pattern.factory.Sender;
import _86_design_pattern.factory.SmsSender;

/**
 * 静态工厂方法模式
 * 将多个工厂方法模式中的方法加上static关键字修饰，这样就不需要创建工厂实例，直接调用即可。
 */
public class StaticSendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}
