package com.yy.leetcode.easy;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/14.
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class L203_RemoveElements {

    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if(head == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while(cur != null && cur.next != null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new Solution().removeElements(ListNode.of(new int[]{1, 2, 3, 4, 5, 6}), 6);
        System.out.println(node);
    }
}
