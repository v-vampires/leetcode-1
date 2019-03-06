package com.yy.leetcode.medium;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/15.
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class L147_InsertionSortList {
    private static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            while (head != null && head.next != null){
                ListNode next = head.next;
                ListNode cur = dummy;
                while(cur != null && cur.next != null){
                    if(next.val > cur.val && next.val <= cur.next.val){
                        ListNode nNext = next.next;
                        ListNode cNext = cur.next;
                        next.next = cNext;
                        cur.next = next;
                        next.next = null;
                        head = nNext;
                        break;
                    }else{
                        cur = cur.next;
                    }
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().insertionSortList(ListNode.of(new int[]{4,2,1,3})));
    }
}
