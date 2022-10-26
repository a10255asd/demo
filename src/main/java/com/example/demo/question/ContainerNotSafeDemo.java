package com.example.demo.question;

import org.springframework.util.StringUtils;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author LiuJixue
 * @Date 2022/10/25 11:08
 * @PackageName:com.example.demo.question
 * @ClassName: ContainerNotSafeDemo
 * @Description: TODO
 * @Version 1.0
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //listNotSafe();
        //setNosafe();
        Map<String,String> map = new HashMap<>();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }

    private static void setNosafe() {

        //Set<String> set = Collections.synchronizedSet(new HashSet<>()) ;
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(1)).start();
        }
    }

    private static void listNotSafe() {
        //        List<String> list = new Vector<>();
        //List<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
    }
}
