package _86_design_pattern.singleton;

/**
 * 饿汉式
 */
public class HungryMan {
    private HungryMan instance = new HungryMan();

    private HungryMan() {}

    public HungryMan getInstance() {
        return instance;
    }
}
