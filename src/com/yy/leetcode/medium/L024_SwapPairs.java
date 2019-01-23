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
            if (head == null || head.next == null) return head;
            ListNode newNode = null;
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = cur.next;
            while (next != null) {
                pre = cur;
                cur.next = next.next;
                next.next = cur;//已经交换完


                if (newNode == null) {
                    newNode = next;
                }
                cur = cur.next;
                next = cur != null ? cur.next : null;
            }

            return newNode;
        }
    }

    private static class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dump = new ListNode(0);
            dump.next = head;
            head = dump;
            while (head.next != null && head.next.next != null) {
                ListNode n1 = head.next;
                ListNode n2 = head.next.next;
                head.next = n2;
                n1.next = n2.next;
                n2.next = n1;
                head = n1;
            }
            return dump.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(l1);

        ListNode ll = new Solution1().swapPairs(l1);
        System.out.println(ll);
    }
}
