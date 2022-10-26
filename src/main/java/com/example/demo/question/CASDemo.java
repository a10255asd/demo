package com.example.demo.question;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiuJixue
 * @Date 2022/10/21 13:36
 * @PackageName:com.example.demo.question
 * @ClassName: CASDemo
 * @Description: TODO
 * @Version 1.0
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data :" + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(4, 1024) + "\t current data :" + atomicInteger);
    }
}
