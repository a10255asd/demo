package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 09:26
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode21
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode21 {
    /**
     * 合并两个有序链表
     */
    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next =mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next =mergeTwoLists(list2.next,list1);
            return list2;
        }
    }
}
