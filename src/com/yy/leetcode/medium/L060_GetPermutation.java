package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/27.
 * 60. 第k个排列
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 */
public class L060_GetPermutation {
    private static class Solution {
        public String getPermutation(int n, int k) {
            List<String> ans = new ArrayList<>();
            List<Character> str = new ArrayList<>();
            backTrack(ans, str, n);
            return ans.get(k-1);
        }

        private void backTrack(List<String> ans, List<Character> str, int n){
            if(str.size() == n){
                Character[] characters = str.toArray(new Character[str.size()]);
                char[] chars = new char[characters.length];
                int i=0;
                for (Character character : characters) {
                    chars[i++] = character;
                }
                ans.add(new String(chars));
            }else{
                for (int i = 1; i <= n; i++) {
                    char c = Character.forDigit(i, 10);
                    if(str.contains(c)) continue;
                    str.add(c);
                    backTrack(ans, str, n);
                    str.remove(str.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String permutation = new Solution().getPermutation(3, 3);
        System.out.println(permutation);
    }
}
