package com.yy.leetcode.easy;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/11.
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class L083_DeleteDuplicates {
    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            while(head != null){
                pre.next = head;
                ListNode next = head.next;
                while(next != null && next.val == head.val){
                    next = next.next;
                }
                head = next;

                pre = pre.next;
                pre.next = null;
            }
            return dummy.next;
        }
    }

    private static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while(cur != null && cur.next != null){
                if(cur.val == cur.next.val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(new Solution1().deleteDuplicates(l1));
    }
}
