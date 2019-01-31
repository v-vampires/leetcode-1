package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/1/29.
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class L086_Partition {

    private static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode low = new ListNode(0);
            ListNode lowCur = low;
            ListNode hi = new ListNode(0);
            ListNode hiCur = hi;
            while (head != null){
                if(head.val >= x){
                    hiCur.next = head;
                    hiCur = hiCur.next;
                }else{
                    lowCur.next = head;
                    lowCur = lowCur.next;
                }
                head = head.next;
            }

            lowCur.next = hi.next;
            hiCur.next = null;

            return low.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode partition = new Solution().partition(l1, 3);
        System.out.println(partition);
    }

}
