package com.example.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LiuJixue
 * @Date 2022/9/30 17:17
 * @PackageName:com.example.demo.juc
 * @ClassName: CompletableFutureDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread11());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(futureTask.get());
    }
}

class MyThread11 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("------come in call()");
        return "hello Callable";
    }
}