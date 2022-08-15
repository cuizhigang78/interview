package _99_common.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读取...");
            TimeUnit.MILLISECONDS.sleep(300);
            Object rtValue = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成！结果：\t" + rtValue);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
    
    public void set(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入...");
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
