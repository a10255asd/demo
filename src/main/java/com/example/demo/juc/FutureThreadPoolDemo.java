package com.example.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2022/9/30 17:28
 * @PackageName:com.example.demo.juc
 * @ClassName: FutureThreadPoolDemo
 * @Description: TODO
 * @Version 1.0
 */
public class FutureThreadPoolDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 3个任务，开启多个异步任务线程处理，请问耗时多少
        FutureTask<String> futureTask1 = new FutureTask<>(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1 over";
        });
        FutureTask<String> futureTask2 = new FutureTask<>(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2 over";
        });
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime" + (endTime - startTime) + "毫秒");
        System.out.println(Thread.currentThread().getName()+"\t -----endTime");
    }

    private static void m1() {
        // 3个任务，目前只有一个main处理，请问耗时多久
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime" + (endTime - startTime) + "毫秒");
        System.out.println(Thread.currentThread().getName()+"\t -----endTime");
    }
}
