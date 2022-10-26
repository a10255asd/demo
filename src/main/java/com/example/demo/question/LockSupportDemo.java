package com.example.demo.question;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiuJixue
 * @Date 2022/10/11 10:26
 * @PackageName:com.example.demo.question
 * @ClassName: LockSupportDemo
 * @Description: TODO
 * @Version 1.0
 */
public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public static void main(String[] args) {
        //SynchronizedWaitNotify();
        //lockAwaitSignal();
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park(); // 直接被阻塞了，等待通知，或者是等待放行，需要许可证。
            System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒");
        }, "A");
        a.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread b = new Thread(() -> {
            LockSupport.unpark(a); // b 唤醒 a 不需要锁块
            System.out.println(Thread.currentThread().getName() + "\t" + "-----发出通知");
        }, "B");
        b.start();
    }

    private static void lockAwaitSignal() {
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒");
            } finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "-----通知 ");
            } finally {
                lock.unlock();
            }
        },"B").start();
    }

    private static void SynchronizedWaitNotify() {
        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" + "-----come in ");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒");
            }
        },"A").start();

        new Thread(()-> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            }
        },"B").start();
    }
}
