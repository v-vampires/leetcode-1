package com.yy.leetcode.util;

/**
 * Created by fitz.li on 2019/1/23.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(this.val));
        ListNode next = this.next;
        while(next != null){
            sb.append(",").append(next.val);
            next = next.next;
        }
        return sb.toString();
    }


    public static ListNode of(int[] vals){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (Integer val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1, 2, 3, 4});
        System.out.println(head);
    }
}
