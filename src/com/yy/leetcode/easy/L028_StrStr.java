package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/23.
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class L028_StrStr {
    private static class Solution {
        public int strStr(String haystack, String needle) {
            if(needle == null || needle.length()==0) return 0;
            if(needle.length() > haystack.length()) return -1;
            char[] h = haystack.toCharArray();
            char[] c = needle.toCharArray();
            for (int i = 0; i < h.length - c.length + 1; i++) {
                if(match(h, c, i)){
                    return i;
                }
            }
            return -1;
        }

        private boolean match(char[] haystack, char[] needle, int fromIndex){
            int i=0;
            while(i<needle.length){
                if(haystack[fromIndex] != needle[i]){
                    return false;
                }
                i++;
                fromIndex++;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}
