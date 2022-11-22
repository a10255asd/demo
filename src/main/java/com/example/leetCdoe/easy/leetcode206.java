package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/22 09:12
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode260
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode206 {
    //206. 反转链表
    public ListNode reverseList(ListNode head) {
        // 创建一个头节点 指向null
        ListNode pre = null;
        //创建一个移动的当前节点
        ListNode cur = head;
        //创建一个临时节点，用来记录cur.next节点
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }
}
