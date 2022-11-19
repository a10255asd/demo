package com.example.leetCdoe.medium;

/**
 * @Author LiuJixue
 * @Date 2022/11/17 14:50
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode2
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode2 {
    //2. 两数相加
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;

            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
