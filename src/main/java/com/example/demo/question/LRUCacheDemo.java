package com.example.demo.question;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/10/20 11:24
 * @PackageName:com.example.demo.question
 * @ClassName: LRUCacheDemo
 * @Description: TODO
 * @Version 1.0
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {

    private int capacity;// 缓存坑位

    public LRUCacheDemo(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lRUCacheDemo = new LRUCacheDemo<>(3);
        lRUCacheDemo.put(1,"a");
        lRUCacheDemo.put(2,"b");
        lRUCacheDemo.put(3,"c");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(4,"d");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"d");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"d");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"d");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(5,"d");
    }
}
