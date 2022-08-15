package _86_design_pattern.factory.factoryMethodPattern.multiFactory;

import _86_design_pattern.factory.MailSender;
import _86_design_pattern.factory.Sender;
import _86_design_pattern.factory.SmsSender;

/**
 * 多个工厂方法模式
 * 该模式是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确地创建对象，
 * 而多个工厂方法模式提供多个工厂方法，分别创建对象。
 */
public class MultiSendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}
