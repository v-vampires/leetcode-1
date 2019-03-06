package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

/**
 * Created by fitz.li on 2019/2/12.
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 实现思路：判断当前节点的左右子树的是否是平衡树，如果不平衡则返回，否则判断子节点的左右子树是否是平衡
 */
public class L110_IsBalanced {
    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if(Math.abs(leftHeight - rightHeight) > 1){
                return false;
            }else{
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }
        private int getHeight(TreeNode node) {
            if(node == null) return 0;
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Solution().isBalanced(root));
    }
}
