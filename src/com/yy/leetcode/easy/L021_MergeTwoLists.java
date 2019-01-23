package com.yy.leetcode.easy;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/1/23.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class L021_MergeTwoLists {

    private static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode newHead = new ListNode(0);
            ListNode cur = newHead;
            while(l1 != null && l2 != null){
                ListNode tmp;
                if(l1.val <= l2.val){
                    tmp = l1;
                    l1 = l1.next;
                }else{
                    tmp = l2;
                    l2 = l2.next;
                }
                cur.next = tmp;
                cur = cur.next;

            }
            ListNode tmp = null;
            if(l1 != null) tmp = l1;
            if(l2 != null) tmp = l2;
            cur.next = tmp;
            return newHead.next;
        }
    }

    /**
     * merge by recursive
     * 思路：每次取两个链表中最小的一个节点
     */
    private static class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode l0 = l1.val <= l2.val ? l1 : l2;
            l0.next = l1.val <= l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);
            return l0;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        System.out.println(l1);

        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        //ListNode r4 = new ListNode(5);
        r1.next = r2;
        r2.next = r3;
        //r2.next = r4;
        System.out.println(r1);

        ListNode listNode = new Solution1().mergeTwoLists(l1, r1);
        System.out.println(listNode);
    }
}
