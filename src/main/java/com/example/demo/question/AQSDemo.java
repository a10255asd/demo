package com.example.demo.question;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiuJixue
 * @Date 2022/10/12 23:51
 * @PackageName:com.example.demo.question
 * @ClassName: AQSDemo
 * @Description: TODO
 * @Version 1.0
 */
// 带入一个银行办理业务的案例来模拟我们的AQS 如何进行线程的管理和通知唤醒机制
    // 三个线程模拟三个来银行网点，受理窗口办理业务的顾客
public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        // A 顾客就是第一个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---A Thread come in");
                try {TimeUnit.MINUTES.sleep(20);}catch (InterruptedException e){e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        },"A").start();
        // 第二个顾客，第二个线程 -》 由于受理业务的窗口只有一个（只能一个线程持有锁），此时B只能等待
        // 进入候客区
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---B Thread come in");
                try {TimeUnit.MINUTES.sleep(20);}catch (InterruptedException e){e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        },"B").start();
        // 第三个顾客，第二个线程 -》 由于受理业务的窗口只有一个（只能一个线程持有锁），此时C只能等待
        // 进入候客区
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---C Thread come in");
                try {TimeUnit.MINUTES.sleep(20);}catch (InterruptedException e){e.printStackTrace();}
            }finally {
                lock.unlock();
            }
        },"C").start();

    }

}
