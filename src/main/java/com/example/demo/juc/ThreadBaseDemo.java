package com.example.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2022/9/29 22:09
 * @PackageName:com.example.demo.juc
 * @ClassName: ThreadBaseDemo
 * @Description: TODO
 * @Version 1.0
 */
public class ThreadBaseDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 开始运行，"
                    + (Thread.currentThread().isDaemon()?"守护线程":"用户线程"));
            while (true){

            }
        },"t1");
        t1.setDaemon(true);
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"\t----------end");
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}
class MyThread2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        return null;
    }
}


