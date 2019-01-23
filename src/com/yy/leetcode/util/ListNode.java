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
}
