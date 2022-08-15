package _17_SOFE_OOM;

/**
 * create by 携山超 on 2020/4/23
 *
 * java.lang.StackOverFlowError
 *
 *      Throwable
 *      Error
 *      VritualMachineError
 *      StackOverflowError
 *
 */
public class SOFEDemo {
    public static void main(String[] args) {
        // 在jvm运行时的数据区域中有一个java虚拟机栈，当执行java方法时会进行压栈弹栈的操作。
        // 在栈中会保存局部变量，操作数栈，方法出口等等。
        // jvm规定了栈的最大深度，当执行时栈的深度大于了规定的深度，就会抛出StackOverflowError错误。
        stackOverFlowError();
        // Exception in thread "main" java.lang.StackOverflowError
    }

    // 采用递归的方式，将栈内存撑满
    // -Xss(-XX:ThreadStackSize),默认为512-1024k
    private static void stackOverFlowError() {
        stackOverFlowError();
    }
}
