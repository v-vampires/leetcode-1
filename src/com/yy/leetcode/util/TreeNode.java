package com.yy.leetcode.util;

/**
 * Created by fitz.li on 2019/1/25.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    public static TreeNode of(Integer[] vals) {
        TreeNode root = null;
        TreeNode[] nodes = new TreeNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            TreeNode node = vals[i] == null ? null : new TreeNode(vals[i]);
            nodes[i] = node;
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i]== null) continue;
            if(i==0){
                root = nodes[i];
            }else{
                if((i-1) % 2 == 0){
                    TreeNode par = findParent(nodes, (i - 1) / 2);
                    par.left = nodes[i];
                }else if((i-2) % 2 == 0){
                    TreeNode par = findParent(nodes, (i - 2) / 2);
                    par.right = nodes[i];
                }
            }
        }
        return root;
    }


    private static TreeNode findParent(TreeNode[] nodes, int index){
        while(nodes[index] == null){
            index++;
        }
        return nodes[index];
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(root);
    }
}
