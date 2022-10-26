package com.example.demo.question;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 11:25
 * @PackageName:com.example.demo.question
 * @ClassName: ReadWriteLockDemo
 * @Description: TODO
 * @Version 1.0
 */
// 资源类
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    //private Lock lock = new ReentrantLock();
    // 写缓存三个操作，写、读、清空
    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入" + key);
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成" + key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取" );
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成:" +result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    /**
     * 读写锁demo
     * 读锁的共享锁可保证并发读诗非常高效的，读写，写读，写写的过程是互斥的。
     * */
    public static void main(String[] args) {
        MyCache myCache =new MyCache();
        for (int i = 1; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+ "",tempInt + "");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
