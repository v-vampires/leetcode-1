package com.yy.leetcode.easy;

import com.yy.leetcode.util.TreeNode;

/**
 * Created by fitz.li on 2019/1/30.
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class L101_IsSymmetric {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode n1, TreeNode n2){
            if(n1 == null && n2 == null) return true;
            if(n1 == null || n2 == null) return false;
            return n1.val == n2.val && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
        }
    }
}
