package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/20.
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class L152_MaxProduct {
    private static class Solution {
        public int maxProduct(int[] nums) {
            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int retMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] > 0){
                    dpMax[i] = Math.max(dpMax[i-1] * nums[i], nums[i]);
                    dpMin[i] = Math.min(dpMin[i-1] * nums[i], nums[i]);
                }else{
                    dpMax[i] = Math.max(dpMin[i-1] * nums[i], nums[i]);
                    dpMin[i] = Math.min(dpMax[i-1] * nums[i], nums[i]);
                }
                retMax = Math.max(dpMax[i], retMax);
            }
            return retMax;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{-2,0,-4}));
    }
}
