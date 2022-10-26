package com.example.demo.juc;

import java.util.concurrent.*;

/**
 * @Author LiuJixue
 * @Date 2022/10/8 23:17
 * @PackageName:com.example.demo.juc
 * @ClassName: CompletableFutureBuildDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        //CompletableFuture completableFuture = new CompletableFuture();
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },threadPool);
//        System.out.println(voidCompletableFuture.get());
        CompletableFuture<String> objectCompletableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello supplyAsync";
        },threadPool);
        System.out.println(objectCompletableFuture.get());
        threadPool.shutdown();
    }
}
