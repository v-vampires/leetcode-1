package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

/**
 * Created by fitz.li on 2019/1/26.
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 实现思路：递归
 */
public class L100_IsSameTree {

    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q != null) return false;
            if(p != null && q == null) return false;
            if(p != null && q != null){
                if(p.val != q.val){
                    return false;
                }else{
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        //l1.left = l2;
        l1.right = r2;
        TreeNode r1 = new TreeNode(3);
        root1.left = l1;
        root1.right = r1;

        TreeNode root2 = new TreeNode(1);
        TreeNode r2l1  = new TreeNode(2);
        TreeNode r2l2 = new TreeNode(4);
        TreeNode r2r2 = new TreeNode(5);
        r2l1.left = r2l2;
        r2l1.right = r2r2;
        TreeNode r2r1  = new TreeNode(3);
        root2.left = r2l1;
        root2.right = r2r1;
        boolean sameTree = new Solution().isSameTree(root1, root2);
        System.out.println(sameTree);
    }
}
