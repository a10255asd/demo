package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/8 15:37
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode83
 * @Description: TODO
 * @Version 1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null || cur.next != null) {
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
        }
        return cur;
    }
}











