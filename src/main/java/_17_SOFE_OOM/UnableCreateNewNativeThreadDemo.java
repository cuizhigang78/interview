package _17_SOFE_OOM;

/**
 * create by 携山超 on 2020/4/25
 *
 * java.lang.OutOfMemoryError:unable to create new native thread
 */
public class UnableCreateNewNativeThreadDemo {
    // linux系统默认允许单个进程可以创建的线程数是1024个（root用户无上限），windows很多，跑不完
    // 如果超过这个限制，就会出现java.lang.OutOfMemoryError:unable to create new native thread
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println(++i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    // 解决办法：
    // 1. 减少创建的线程数量
    // 2. 修改操作系统的默认配制

    // linux下
    // ulimit -u 查看本用户下最大线程数
    // vim /etc/security/limits.d/90-nproc.conf 修改最大线程数
}
