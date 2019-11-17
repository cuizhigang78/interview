package com.cui.init;

public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(1)");
    }

    Father() {
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    public int test() {
        System.out.println("(4)");
        return 1;
    }

    public static int method() {
        System.out.println("(5)");
        return 1;
    }
}
/**
 * (5)
 * (1)
 * (10)
 * (6)
 *
 * (9)
 * (3)
 * (2)
 * (9)
 * (8)
 * (7)
 *
 * (9)
 * (3)
 * (2)
 * (9)
 * (8)
 * (7)
 */
