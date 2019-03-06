package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/18.
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class L091_NumDecodings {
    /**
     * 1=>
     * 1
     * <p>
     * 12=>
     * 1,2
     * 12
     * <p>
     * 121=>
     * 1,2,1
     * 12,1
     * 1,21
     * <p>
     * 1212=>
     * 1,2,1,2
     * 12,1,2
     * 1,21,2
     * 1,2,12
     * 12,12
     * 到这里就可以总结出规律了，对于1212,其实是两种解码的和：
     * <p>
     * 1,2,1,(2)
     * 1,21,(2)
     * 12,1,(2)
     * -----------
     * 1,2,(12)
     * 12,(12)
     * ---------------------
     * 作者：racaljk
     * 来源：CSDN
     * 原文：https://blog.csdn.net/racaljk/article/details/79337727
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     */

    private static class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.startsWith("0") || s.indexOf("00") > -1) return 0;
            if (s.length() == 1) return 1;
            char[] chars = s.toCharArray();
            int[] dp = new int[chars.length + 1];
            dp[0] = 1;
            for (int i = 1; i <= chars.length; i++) {
                dp[i] = 0;
                int t = chars[i - 1] - '0';
                if (t >= 1 && t <= 9) {
                    dp[i] += dp[i - 1];
                }
                if (i >= 2) {
                    t = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                    if (t >= 10 && t <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[chars.length];
        }
    }

    private static class Solution1{
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if(chars.length == 0 || chars[0] == '0') return 0;
            if(chars.length <=1) return 1;
            int[] dp = new int[chars.length + 1];
            dp[0] = 1;
            for (int i = 1; i <= chars.length ; i++) {
                int t = chars[i - 1] - '0';
                if(t >=1 && t <= 9){
                    dp[i] = dp[i-1];
                }
                if(i >= 2){
                    t = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                    if(t >=10 && t<=26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[chars.length];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("2020"));
    }
}
