package com.yy.leetcode.medium;

import com.yy.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class L102_LevelOrder {
    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelSize = queue.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode pop = queue.pop();
                    tmp.add(pop.val);
                    if(pop.left != null) queue.add(pop.left);
                    if(pop.right != null) queue.add(pop.right);
                }
                if(!tmp.isEmpty()){
                    ans.add(tmp);
                }
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
        l1.right = r2;
        TreeNode r1 = new TreeNode(3);
        root1.left = l1;
        root1.right = r1;

        List<List<Integer>> lists = new Solution().levelOrder(root1);
        System.out.println(lists);
    }
}
