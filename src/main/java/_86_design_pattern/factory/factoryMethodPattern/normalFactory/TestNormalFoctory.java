package _86_design_pattern.factory.factoryMethodPattern.normalFactory;

import _86_design_pattern.factory.Sender;

public class TestNormalFoctory {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("mail");
        if (sender != null) {
            sender.send();
        }
    }
}
