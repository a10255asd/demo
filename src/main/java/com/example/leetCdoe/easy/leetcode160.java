package com.example.leetCdoe.easy;

public class leetcode160 {
    //160. 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 若a或b为null，则没有交点
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        // pA的路程是 headA + headB ，pB的路程是 headB + headA 若相交必有 pA =  pB；
        while(pA != pB){
            pA = pA == null?headB:pA.next;
            pB =pB == null ?headA:pB.next;
        }
        return pA;
    }
}
