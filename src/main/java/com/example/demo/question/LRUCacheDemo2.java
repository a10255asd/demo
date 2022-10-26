package com.example.demo.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/10/20 12:39
 * @PackageName:com.example.demo.question
 * @ClassName: LRUCacheDemo2
 * @Description: TODO
 * @Version 1.0
 */
public class LRUCacheDemo2 {
    // map负责查找，构造一个虚拟的双向链表，它里面安装的就是一个个node节点，作为数据载体
    // 构造一个node节点作为数据载体
    public static void main(String[] args) {

    }

    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;
        public Node(){
            this.prev = this.next = null;
        }
        public Node(K key,V value){
            this.key =key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // 2构造一个双向队列，里面安放的就是我们的node
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;
        // 2.1 构造方法
        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.next = head;
        }
        // 2。2添加到头
        public void addHead(Node<K,V> node){
            node.next = tail;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        // 2.3.删除节点
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }
        // 2.4获得最后一个节点
        public Node getLast(){
            return tail.prev;
        }
    }
    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize){
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node<Integer,Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if(map.size() == cacheSize){ //坑位满了
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            // 新增一个value
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }
}
