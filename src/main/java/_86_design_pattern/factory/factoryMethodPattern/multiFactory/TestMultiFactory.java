package _86_design_pattern.factory.factoryMethodPattern.multiFactory;

public class TestMultiFactory {
    public static void main(String[] args) {
        MultiSendFactory sendFactory = new MultiSendFactory();
        sendFactory.produceMail().send();
        sendFactory.produceSms().send();
    }
}
