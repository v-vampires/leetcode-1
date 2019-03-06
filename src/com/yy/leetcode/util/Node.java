package com.yy.leetcode.util;

import java.util.List;

/**
 * Created by fitz.li on 2019/2/5.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
