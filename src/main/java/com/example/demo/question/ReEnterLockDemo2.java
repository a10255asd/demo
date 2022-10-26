package com.example.demo.question;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiuJixue
 * @Date 2022/10/10 23:21
 * @PackageName:com.example.demo.question
 * @ClassName: ReEnterLockDemo2
 * @Description: TODO
 * @Version 1.0
 */
public class ReEnterLockDemo2 {
    public static void main(String[] args) {
        //new ReEnterLockDemo2().m1();
        new Thread(()->{
            lock.lock();
            lock.lock();
            try {
                System.out.println("=====外层");
                lock.lock();
                try {
                    System.out.println("======内层");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "----调用开始");
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
    /**
    public synchronized void m1(){
        System.out.println("======外");
        m2();
    }
    public synchronized void m2(){
        System.out.println("====中");
        m3();
    }
    public synchronized void m3(){
        System.out.println("====内");
    }
    */
    static Lock lock = new ReentrantLock();


}
