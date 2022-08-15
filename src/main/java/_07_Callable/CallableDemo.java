package _07_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 第3种获得线程的方法
 */
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tcome in MyThread.call()");
        return 1024;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask, "BBB").start();
        // 要求获取Callable线程的计算结果，如果没有计算完成就要去强求，这样就会导致堵塞。
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
