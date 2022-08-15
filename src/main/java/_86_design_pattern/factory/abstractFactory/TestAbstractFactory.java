package _86_design_pattern.factory.abstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        provider.produce().send();
    }
}
