package com.example.demo.question;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiuJixue
 * @Date 2022/10/20 14:43
 * 验证volatile的可见性
 * 加入int number =0;number 变量之前跟美没有添加volatile关键字修饰
 * 验证 volatile不保证原子性（不可分割），也即某个线程在做某个具体业务的时候，中间不可以被加塞或者被分割。需要整体完整
 *      要么同时成功，要么同时失败。
 *
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //seeOKByVolatile();
        MyData myData = new MyData();
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        // 需要等待上面20个线程全部计算完成后在用main线程取得最终的结果值是多少
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally nember value " +  myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally nember value " +  myData.atomicInteger);
    }



    private static void seeOKByVolatile() {
        MyData myData = new MyData(); //线程要操作资源类
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in ");
            // 暂停一会
            try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {throw new RuntimeException(e);}
            myData.addTO60();
            System.out.println(Thread.currentThread().getName() + "\t update nember value" + myData.number);
        },"AAA").start();
        // 第二个线程 main线程
        while (myData.number == 0){// main线程一直等待循环，直到number值不等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t misson is over,main get number value" + myData.number);
    }
}

class MyData{
    volatile int number = 0;
    public void addTO60(){
        this.number = 60;
    }
    // 请注意此时number前面是加了volatile关键字修饰的
    public  void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}