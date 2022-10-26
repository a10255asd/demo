package com.example.demo.question;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 10:58
 * @PackageName:com.example.demo.question
 * @ClassName: SpinLockDemo
 * @Description: TODO
 * @Version 1.0
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in ");
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(Thread.currentThread().getName() + "进行比较");
        }
        System.out.println(Thread.currentThread().getName() + "加锁");
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "解锁");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {throw new RuntimeException(e);}
            spinLockDemo.myUnlock();
        },"AA").start();
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
        new Thread(()->{
            spinLockDemo.myLock();
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
            spinLockDemo.myUnlock();
        },"BB").start();

    }
}
