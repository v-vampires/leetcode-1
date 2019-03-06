package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by fitz.li on 2019/2/5.
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 实现思路：1. 递归；2、 利用队列的入队和出队，进行迭代
 */
public class L104_MaxDepth {
    private static class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }

    private static class Solution1 {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            if(root == null) return depth;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                depth++;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = q.pop();
                    if(pop.left != null) q.offer(pop.left);
                    if(pop.right != null) q.offer(pop.right);
                }
            }
            return depth;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        l1.left = l2;
        l1.right = null;
        TreeNode r1 = new TreeNode(3);
        r1.left = null;
        r1.right = r2;
        root1.left = l1;
        root1.right = r1;
        System.out.println(new Solution1().maxDepth(root1));
    }

}
