package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/1/26.
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 实现思路：右旋转换为左旋 左旋n = size - k % size
 */
public class L061_RotateRight {

    private static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return null;
            ListNode cur = head;
            int size = 1;
            while(cur.next != null){
                size++;
                cur = cur.next;
            }
            ListNode tail = cur;
            int l = size - k % size;//左旋数量
            
            while(l > 0){
                tail.next = head;
                tail = tail.next;
                head = head.next;
                l--;
            }
            tail.next = null;

            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(l1);

        ListNode listNode = new Solution().rotateRight(l1, 1);
        System.out.println(listNode);
    }
}
