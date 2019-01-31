package com.yy.leetcode.hard;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/1/24.
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class L023_MergeKLists {
    private static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length < 1) return null;
            ListNode result = lists[0];
            for (int i = 1; i < lists.length; i++) {
                result = mergeTwoLists2(result, lists[i]);
            }
            return result;
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode l0 = l1.val <= l2.val ? l1 : l2;
            l0.next = l1.val <= l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);
            return l0;
        }

        private ListNode mergeTwoLists2(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;

            ListNode cur = new ListNode(0);
            ListNode l0 = cur;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if(l1 != null){
                cur.next = l1;
            }
            if(l2 != null){
                cur.next = l2;
            }
            return l0.next;
        }
     }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l4;
        l4.next = l5;
        System.out.println(l1);

        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        System.out.println(r1);

        ListNode m2 = new ListNode(2);
        ListNode m6 = new ListNode(6);
        m2.next = m6;
        System.out.println(m2);

        ListNode[] ll = new ListNode[3];
        ll[0] = l1;
        ll[1] = r1;
        ll[2] = m2;
        ListNode listNode = new Solution().mergeKLists(ll);
        System.out.println(listNode);
    }
}
