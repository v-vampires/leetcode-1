package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/2/19.
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class L053_MaxSubArray {

    /**
     * 以第n个数为结束点的子序列和的递推关系
     * f(n) = max(f(n-1)+nums[n], nums[n])
     */
    private static class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 0) return 0;
            int max = nums[0];
            int retMax = max;
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max+nums[i], nums[i]);
                retMax = Math.max(retMax, max);
            }
            return retMax;
        }
    }

    private static class Solution1 {
        public int maxSubArray(int[] nums) {
            if(nums.length == 0) return 0;
            int max = nums[0];
            int[] dp = new int[nums.length];//dp[n]表示到第n个节点的序列和，dp[n] = max(dp[n-1]+a[n], a[n])
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
