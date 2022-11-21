package com.example.leetCdoe.medium;

import java.util.HashMap;
import java.util.Map;

public class leetcode138 {
    //138. 复制带随机指针的链表
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            Node headNew =  new Node(head.val);
            map.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
