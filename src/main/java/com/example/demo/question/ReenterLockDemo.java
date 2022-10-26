package com.example.demo.question;

/**
 * @Author LiuJixue
 * @Date 2022/10/10 23:12
 * @PackageName:com.example.demo.question
 * @ClassName: ReEnterLockDemo
 * @Description: TODO
 * @Version 1.0
 */
public class ReenterLockDemo {
    static Object objectLockA = new Object();
    public static void m1(){
        new Thread(()->{
            synchronized (objectLockA){
                System.out.println(Thread.currentThread().getName() + "\t" + "------外层调用");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName() + "\t" + "------中层调用");
                    synchronized (objectLockA){
                        System.out.println(Thread.currentThread().getName() + "\t" + "------内层调用");
                    }
                }
            }
        },"t1").start();
    }

    public static void main(String[] args) {
        m1();
    }
}
