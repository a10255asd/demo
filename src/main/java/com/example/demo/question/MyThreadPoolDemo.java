package com.example.demo.question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author LiuJixue
 * @Date 2022/11/9 15:55
 * @PackageName:com.example.demo.question
 * @ClassName: MythreadPoolDemo
 * @Description: TODO
 * @Version 1.0
 *
 * 第4中获得使用java多线程的方式，线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);// 一池5个处理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 1池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一个池子n个线程
        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
