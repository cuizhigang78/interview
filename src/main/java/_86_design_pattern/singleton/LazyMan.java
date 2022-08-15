package _86_design_pattern.singleton;

/**
 * 懒汉式
 */
public class LazyMan {
    private volatile LazyMan instance;

    private LazyMan () {

    }

    public LazyMan getInstance() {
        if(instance == null) {
            synchronized (LazyMan.class) {
                if (instance == null) {
                    instance = new LazyMan();
                }
            }
        }
        return instance;
    }
}
