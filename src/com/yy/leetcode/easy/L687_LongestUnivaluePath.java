package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

/**
 * Created by fitz.li on 2019/1/25.
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 实现思路：
 */
public class L687_LongestUnivaluePath {
    private static class Solution {
        public int longestUnivaluePath(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 0;
            return Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right)) + 1;
        }


    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        l1.left = l2;
        l1.right = r2;
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        int i = new Solution().longestUnivaluePath(root);
        System.out.println(i);
    }
}
