package com.yy.leetcode.hard;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/13.
 * 25. k个一组翻转链表
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 实现思路：递归
 */
public class L025_ReverseKGroup {
    private static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = null;
            ListNode cur = head;
            int i= 0;
            ListNode seg = null;
            ListNode pre = null;
            while (cur != null){
                if(seg == null) seg = cur;
                i++;
                if(i%k == 0){
                    ListNode next = cur.next;
                    cur.next = null;//截断
                    ListNode reverse = reverse(seg);
                    if(dummy == null) {
                        dummy = reverse;
                    }
                    if(pre != null) pre.next = reverse;
                    pre = seg;
                    cur = next;
                    seg = null;
                }else{
                    cur = cur.next;
                }
            }
            if(seg != null){
                if(pre != null){
                    pre.next = seg;
                }else{
                    dummy = seg;
                }
            }
            return dummy;
        }

        /**
         * 单链表反转
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head){
            ListNode dummy = null;
            while (head != null){
                ListNode next = head.next;
                head.next = dummy;
                dummy = head;
                head = next;
            }
            return dummy;
        }
    }


    private static class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            int canReverse = 0;
            ListNode node = head;
            while(canReverse < k && node != null){
                node = node.next;
                canReverse++;
            }
            if(canReverse >= k){
                ListNode pre = null;
                ListNode cur = head;
                ListNode next = null;
                while(canReverse > 0 && cur != null){
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    canReverse--;
                }
                if(next != null){
                    head.next = reverseKGroup(next, k);
                }
                return pre;
            }else{
                return head;
            }
        }

    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1,2,3,4,5});
        ListNode listNode = new Solution1().reverseKGroup(head, 2);
        System.out.println(listNode);
    }
}
