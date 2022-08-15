package _86_design_pattern.factory.abstractFactory;

import _86_design_pattern.factory.MailSender;
import _86_design_pattern.factory.Sender;

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
