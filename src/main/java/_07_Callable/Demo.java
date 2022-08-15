package _07_Callable;

import java.util.concurrent.*;

/**
 * @ClassName Demo
 * @Author Maxwell
 * @Date 2021/9/8 23:14
 * @Description Demo
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Future<Integer> submit1 = threadPool.submit(() -> {
            System.out.println("A come in");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("A come out");
            return 1;
        });
        Future<Integer> submit2 = threadPool.submit(() -> {
            System.out.println("B come in");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("B come out");
            return 2;
        });
        Future<Integer> submit3 = threadPool.submit(() -> {
            System.out.println("C come in");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("C come out");
            return 3;
        });

        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());

        threadPool.shutdown();
    }
}
