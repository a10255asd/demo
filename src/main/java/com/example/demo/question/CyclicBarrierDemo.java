package com.example.demo.question;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 15:56
 * @PackageName:com.example.demo.question
 * @ClassName: CyclicBarrierDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    /**
     * CyclicBarrierDemo 做加法 人到齐了才能开会
     * */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,()->{
            System.out.println("******* 召唤神龙");
        });
        for (int i = 1; i <=7; i++) {
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 收集到第：" + tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }

    }
}
