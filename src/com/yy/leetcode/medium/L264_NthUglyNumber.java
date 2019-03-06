package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/23.
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class L264_NthUglyNumber {

    private static class Solution {
        public int nthUglyNumber(int n) {
            int[] ans = new int[n];
            ans[0] = 1;
            int index2 = 0;
            int index3 = 0;
            int index5 = 0;
            for (int i = 1; i < n; i++) {
                ans[i] = Math.min(Math.min(ans[index2] * 2, ans[index3] * 3), ans[index5] * 5);
                if(ans[i] == ans[index2] * 2) index2++;
                if(ans[i] == ans[index3] * 3) index3++;
                if(ans[i] == ans[index5] * 5) index5++;
            }
            return ans[n-1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
