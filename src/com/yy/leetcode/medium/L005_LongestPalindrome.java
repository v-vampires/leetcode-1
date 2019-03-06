package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/21.
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class L005_LongestPalindrome {

    private static class Solution {
        public String longestPalindrome(String s) {
            /**
             * dp[i][j] = n , dp[i][j]表示以s[i]开头，s[j]结尾的回文串长度（如果不是回文串，则为0）
             * 只需要考虑j>=i的情况
             * 首先s[0][0],s[1][1]....都是长度为1的回文串
             * if(j-i==1),s[i]=s[j]则为回文串，d[i][j]=2
             * if(j-i>1),如果s[i+1][j-1]是回文串 && s[i]=s[j],则s[i][j] = s[i+1][j-1] + 2;
             *
             * 为什么dp要定义成二位数组呢，因为要判断每一个字符开始的子串是否为回文
             */
            int[][] dp = new int[s.length()][s.length()];
            char[] chars = s.toCharArray();
            int retMax = 0;
            int start = 0;
            for (int j = 0; j < s.length() ; j++) {
                for (int i = j; i >= 0; i--) {
                    if(i==j){
                        dp[i][j] = 1;
                    }else{
                        if (chars[i] == chars[j]) {
                            if (j - i == 1) {
                                dp[i][j] = 2;
                            } else if (j - i > 1) {
                                if (dp[i + 1][j - 1] > 0) {
                                    dp[i][j] = dp[i + 1][j - 1] + 2;
                                } else {
                                    dp[i][j] = 0;
                                }
                            }
                        } else {
                            dp[i][j] = 0;
                        }
                    }
                    if(dp[i][j] > retMax){
                        retMax = dp[i][j];
                        start = i;
                    }
                }
            }
            return s.substring(start, start+retMax);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abcdbbfcba"));
    }
}
