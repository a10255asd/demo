package com.example.leetCdoe.medium;

public class leetcode61 {
    //61. 旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        // 如果k=0 或者 头节点为null 或者 只有一个节点 返回头节点
        if(k == 0|| head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode temp = head;
        // 计算出节点数量
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        // 计算出需要移动几个位置
        int add = n - k%n;
        if(add == 0){
            return head;
        }
        // 首尾相连
        temp.next = head;
        while (add-- > 0){
            temp = temp.next;
        }
        // 定义头节点
        ListNode ans = temp.next;
        // 断开
        temp.next = null;
        return ans;
    }
}
