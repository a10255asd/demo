package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/23 17:37
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode876
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode876 {
    //876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
