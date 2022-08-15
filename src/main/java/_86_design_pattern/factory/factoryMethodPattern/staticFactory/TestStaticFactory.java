package _86_design_pattern.factory.factoryMethodPattern.staticFactory;

public class TestStaticFactory {
    public static void main(String[] args) {
        StaticSendFactory.produceMail().send();
        StaticSendFactory.produceSms().send();
    }
}
