package _86_design_pattern.factory;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is a mail sender");
    }
}
