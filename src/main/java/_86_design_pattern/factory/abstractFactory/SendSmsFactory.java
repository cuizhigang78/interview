package _86_design_pattern.factory.abstractFactory;

import _86_design_pattern.factory.Sender;
import _86_design_pattern.factory.SmsSender;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
