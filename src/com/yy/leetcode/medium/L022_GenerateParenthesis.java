package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/25.
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class L022_GenerateParenthesis {
    private static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            append(ret, "", 0, 0, n);
            return ret;
        }

        private void append(List<String> ret, String cur, int leftCount, int rightCount, int max) {
            if(cur.length() == max * 2){
                ret.add(cur);
                return;
            }
            if(leftCount < max){
                append(ret, cur + "(", leftCount+1, rightCount, max);
            }
            if(rightCount < leftCount){
                append(ret, cur + ")", leftCount, rightCount+1, max);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }
}
