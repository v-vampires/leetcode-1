package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/26.
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 实现思路：1. 动态规划； 2，递归
 */
public class L070_ClimbStairs {
    private static class Solution {
        public int climbStairs(int n) {
            if(n == 0) return 0;
            if(n == 1) return 1;
            if(n == 2) return 2;
            int a = 1;
            int b = 2;
            int step = 0;
            for (int i = 3; i <= n; i++) {
                step = a + b;
                a = b;
                b = step;
            }
            return step;
        }
    }

    private static class Solution1 {
        public int climbStairs(int n) {
            if(n == 0) return 0;
            if(n == 1) return 1;
            if(n == 2) return 2;
            return climbStairs(n -2) + climbStairs(n-1);
        }
    }

    public static void main(String[] args) {
        int i = new Solution().climbStairs(3);
        System.out.println(i);
    }
}
