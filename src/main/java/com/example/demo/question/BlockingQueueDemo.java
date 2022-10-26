package com.example.demo.question;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 17:21
 * @PackageName:com.example.demo.question
 * @ClassName: BlockingQueueDemo
 * @Description: TODO
 * @Version 1.0
 */
public class BlockingQueueDemo {
    /**
     * 队列
     * 阻塞队列
     * */
    public static void main(String[] args) {
       // List list = new ArrayList<>();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //System.out.println(blockingQueue.add("x"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.offer("x"));

    }
}
