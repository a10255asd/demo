package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/23 11:30
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode141
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode141 {
    //141. 环形链表
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1 != p2){
            if(p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }
}
