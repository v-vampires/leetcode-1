package com.yy.leetcode.easy;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/14.
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class L206_ReverseList {

    private static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = null;
            while(head != null){
                ListNode next = head.next;
                head.next = dummy;
                dummy = head;
                head = next;
            }
            return dummy;
        }
    }

    /**
     * 递归实现
     */
    private static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode next = head.next;//保留下一个节点 2，3，4
            ListNode node = reverseList(next);//将后面的链表反转 4，3，2
            head.next = null;
            next.next = head;//2->1
            return node;//4-3-2-1
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1,2,3,4,5});
        System.out.println(new Solution2().reverseList(head));
    }
}
