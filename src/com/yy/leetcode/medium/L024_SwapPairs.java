package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/1/23.
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class L024_SwapPairs {

    private static class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            head = dummy;
            while (head.next != null && head.next.next != null){
                ListNode n1 = head.next;
                ListNode n2 = head.next.next;
                head.next = n2;
                n1.next = n2.next;
                n2.next = n1;
                head = n1;
            }
            return dummy.next;
        }
    }


    private static class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dump = null;
            ListNode pre = null;
            while (head != null && head.next != null){
                ListNode next = head.next;
                ListNode next1 = next.next;
                head.next = null;
                next.next = head;
                if(dump == null ) dump = next;
                if(pre != null) pre.next = next;
                pre = head;
                head = next1;
            }
            if(head != null) pre.next = head;
            return dump;
        }
    }

    /**
     * 递归实现
     */
    private static class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = null;
            n1.next = head;
            head.next = swapPairs(n2);
            return n1;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(new int[]{1,2,3,4,5});
        System.out.println(l1);

        ListNode ll = new Solution2().swapPairs(l1);
        System.out.println(ll);
    }
}
