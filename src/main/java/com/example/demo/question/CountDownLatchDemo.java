package com.example.demo.question;

import java.util.concurrent.CountDownLatch;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 14:48
 * @PackageName:com.example.demo.question
 * @ClassName: CountDownLatchDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //countDownLatch();
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                count.countDown();
            },CountryEnum.foreach_CountryEnum(i).getRetMsg()).start();
        }
        count.await();
        System.out.println(Thread.currentThread().getName() + "\t ****** 秦帝国，一统华夏");
    }

    private static void countDownLatch() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 上晚自习，离开教室");
                count.countDown();
            },String.valueOf(i)).start();
        }
        count.await();
        System.out.println(Thread.currentThread().getName() + "\t ****** 班长最后关门走人");
    }
}
