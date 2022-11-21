package com.example.leetCdoe.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author LiuJixue
 * @Date 2022/11/21 17:29
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: leetcode19
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode19 {
    //19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟节点，以便于不用判断第一个节点
        ListNode dump = new ListNode(0,head);
        // 创建一个栈
        Deque<ListNode> stack = new LinkedList<ListNode>();
        // 创建一个当前节点
        ListNode cur = dump;
        // 将所有节点放入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        // 弹出n-1数量的节点
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 找到栈最上面的节点
        ListNode pre = stack.peek();
        // 跳过n节点，指向n+1节点
        pre.next = pre.next.next;
        // 虚拟节点的下一个节点是头节点
        ListNode ans = dump.next;
        return ans;
    }
}
