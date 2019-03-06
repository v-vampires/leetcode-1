package com.yy.leetcode.easy;

import com.yy.leetcode.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * 实现思路：利用队列实现广度优先遍历
 */
public class L429_LevelOrder {
    private static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelSize = queue.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    Node pop = queue.pop();
                    tmp.add(pop.val);
                    List<Node> children = pop.children;
                    if(children != null && !children.isEmpty()){
                        for (int j = 0; j < children.size(); j++) {
                            queue.offer(children.get(j));
                        }
                    }
                }
                ans.add(tmp);
            }
            return ans;
        }
    }


    private static class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            addList(ans, 0, root);
            return ans;
        }

        private void addList(List<List<Integer>> ans, int level, Node node) {
            if(node == null){
                return;
            }
            if(ans.size() -1 < level){
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(node.val);
            List<Node> children = node.children;
            if(children != null && !children.isEmpty()){
                for (Node child : children) {
                    addList(ans, level + 1, child);
                }
            }
        }


    }

    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node6 = new Node(6,null);
        List<Node> node3Children = new ArrayList<>();
        node3Children.add(node5);
        node3Children.add(node6);
        Node node3 = new Node(3, node3Children);
        Node node2 = new Node(2,null);
        Node node4 = new Node(4,null);
        List<Node> rootChildren = new ArrayList<>();
        rootChildren.add(node3);
        rootChildren.add(node2);
        rootChildren.add(node4);
        Node root = new Node(1, rootChildren);
        List<List<Integer>> lists = new Solution1().levelOrder(root);
        System.out.println(lists);
    }
}
