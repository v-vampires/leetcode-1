package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/11.
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 实现思路：比较当前节点与下一个节点是否相同，不同就存下来，相同就跳过去
 */
public class L082_DeleteDuplicates {

    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            while(head != null){
                ListNode next = head.next;
                if(next == null || head.val != next.val){
                    pre.next = head;
                    pre = pre.next;
                    pre.next = null;
                }else{
                    next = next.next;
                    while(next != null && head.val == next.val){
                        next = next.next;
                    }
                }
                head = next;
            }
            return dummy.next;
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

        System.out.println(new Solution().deleteDuplicates(l1));
    }
}
