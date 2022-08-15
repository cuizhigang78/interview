package _86_design_pattern.adapter;

/**
 *
 */
public class ClassAdapter extends Source implements Target {
    @Override
    public void method2() {
        System.out.println("this is the target method!");
    }
}
