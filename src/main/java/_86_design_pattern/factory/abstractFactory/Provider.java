package _86_design_pattern.factory.abstractFactory;

import _86_design_pattern.factory.Sender;

public interface Provider {
    public Sender produce();
}
