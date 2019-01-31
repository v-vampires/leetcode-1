package com.yy.leetcode.hard;

import java.util.Stack;

/**
 * Created by fitz.li on 2019/1/26.
 * 32. 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 实现思路：todo
 */
public class L032_LongestValidParentheses {

    private static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Character> k = new Stack<>();
            int max = 0;
            char[] chars = s.toCharArray();
            int len = 0;
            for (char aChar : chars) {
                if(k.isEmpty()){
                    k.push(aChar);
                }else{
                    Character peek = k.peek();
                    if(aChar - peek == 1){
                        k.pop();
                        len +=2;
                        max = Math.max(max, len);
                    }else{
                        k.push(aChar);
                        len = 0;
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int i = new Solution().longestValidParentheses(")()())");
        System.out.println(i);
    }
}
