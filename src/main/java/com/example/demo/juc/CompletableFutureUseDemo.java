package com.example.demo.juc;

import java.util.concurrent.*;

/**
 * @Author LiuJixue
 * @Date 2022/10/9 16:13
 * @PackageName:com.example.demo.juc
 * @ClassName: CompletableFutureUseDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1秒钟后出结果：" + result);
                return result;
            },threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("计算完成，更新系统updateValue：" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况：" + e.getCause() + "\t" + e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

        // 主线程不要理解结束，否则CompletableFuture默认使用的线程池会立即关闭；暂停3秒线程
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

    }
    private static void future() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1秒钟后出结果：" + result);
            return result;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        System.out.println(integerCompletableFuture.get());
    }
}
