package com.example.demo.question;

/**
 * @Author LiuJixue
 * @Date 2022/10/21 10:59
 * @PackageName:com.example.demo.question
 * @ClassName: singletonDemo
 * @Description: TODO
 * @Version 1.0
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法 singletonDemo()");
    }
    //DCL模式（Double Check Lock双端检索机制）
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println();
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
