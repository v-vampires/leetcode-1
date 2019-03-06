package com.yy.leetcode.medium;

import com.yy.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class L103_ZigzagLevelOrder {

    private static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            LinkedList<TreeNode> q = new LinkedList();
            q.offer(root);
            int level = 0;
            while(!q.isEmpty()){
                level++;
                int levelSize = q.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode pop = q.pop();
                    if(level % 2 == 0){
                        tmp.add(0, pop.val);
                    }else{
                        tmp.add(pop.val);
                    }
                    if(pop.left != null) q.offer(pop.left);
                    if(pop.right != null) q.offer(pop.right);
                }
                ans.add(tmp);
            }
            return ans;
        }
    }

    private static class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            addList(ans, 0, root);
            return ans;
        }

        private void addList(List<List<Integer>> ans, int level, TreeNode node) {
            if(node == null){
                return;
            }
            if(ans.size() - 1 < level){
                ans.add(new ArrayList<>());
            }
            if(level % 2 == 0){
                ans.get(level).add(node.val);
            }else{
                ans.get(level).add(0, node.val);
            }

            if(node.left != null) addList(ans, level + 1, node.left);
            if(node.right != null) addList(ans, level + 1, node.right);
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

        List<List<Integer>> lists = new Solution().zigzagLevelOrder(root1);
        System.out.println(lists);

    }
}
