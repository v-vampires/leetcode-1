package com.yy.leetcode.easy;

import com.yy.leetcode.util.ListNode;

/**
 * Created by fitz.li on 2019/2/15.
 */
public class L237_DeleteNode {
    private static class Solution {
        public void deleteNode(ListNode node) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            next.next = null;
        }
    }
}
