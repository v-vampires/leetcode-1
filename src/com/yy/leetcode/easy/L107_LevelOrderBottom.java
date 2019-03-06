package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class L107_LevelOrderBottom {

    private static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()){
                int levelSize = q.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode pop = q.pop();
                    tmp.add(pop.val);
                    if(pop.left != null) q.offer(pop.left);
                    if(pop.right != null) q.offer(pop.right);
                }
                ans.add(0, tmp);
            }
            return ans;
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

        System.out.println(new Solution().levelOrderBottom(root1));
    }
}
