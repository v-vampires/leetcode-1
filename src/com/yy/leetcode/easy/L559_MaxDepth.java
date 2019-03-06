package com.yy.leetcode.easy;

import com.yy.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 * 559. N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 */
public class L559_MaxDepth {
    private static class Solution {
        public int maxDepth(Node root) {
            if(root == null) return 0;
            List<Node> children = root.children;
            int max = 0;
            if(children != null && !children.isEmpty()){
                for (Node child : children) {
                    max = Math.max(max, maxDepth(child));
                }
            }else{
                return 1;
            }
            return max+1;
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
        System.out.println(new Solution().maxDepth(root));
    }
}
