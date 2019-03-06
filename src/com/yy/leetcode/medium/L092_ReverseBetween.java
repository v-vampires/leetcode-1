package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

import java.util.Stack;

/**
 * Created by fitz.li on 2019/1/29.
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class L092_ReverseBetween {

    private static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == n) return head;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int i = 0;
            Stack<ListNode> s = new Stack<>();
            while (head != null){
                i++;
                if(i >= m && i <= n){
                    s.push(new ListNode(head.val));
                }else if(i < m){
                    cur.next = head;
                    cur = cur.next;
                }else if(i > n){
                    while(!s.isEmpty()){
                        ListNode pop = s.pop();
                        cur.next = pop;
                        cur = cur.next;
                    }
                    cur.next = head;
                    cur = cur.next;
                }
                head = head.next;
            }
            while(!s.isEmpty()){
                ListNode pop = s.pop();
                cur.next = pop;
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    private static class Solution1 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == n) return head;
            ListNode cur = head;
            ListNode dummy = new ListNode(-1);
            dummy.next = cur;
            int i = 1;
            ListNode last = dummy;
            for (; i < m; i++) {//跳过前m个，并保留反转之前的最后一个
                last = cur;
                cur = cur.next;
            }
            ListNode next = cur.next;
            ListNode pre = null;
            ListNode first = cur;//要反转的第一个元素
            ListNode reverse = new ListNode(-1);
            for (; cur != null && i <= n; i++) {
                next = cur.next;//先将下一个节点保存下来
                cur.next = pre;//将当前节点的的next指向上一个节点
                pre = cur;
                reverse.next = cur;
                cur = next;
            }
            first.next = next;

            last.next = reverse.next;
            return dummy.next;
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
        ListNode listNode = new Solution1().reverseBetween(l1, 2, 4);
        System.out.println(listNode);
    }
}
