package com.example.demo.question;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 17:11
 * @PackageName:com.example.demo.question
 * @ClassName: SemaphoreDemo
 * @Description: TODO
 * @Version 1.0
 */
public class SemaphoreDemo {
    /**
     * 信号量例子
     * */

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 模拟3个车位
        // 模拟6部汽车
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {throw new RuntimeException(e);}
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开车位" );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
