package _86_design_pattern.adapter;

public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.method1();
        target.method2();
    }
}
