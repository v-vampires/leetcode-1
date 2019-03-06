package com.yy.leetcode.hard;

/**
 * Created by fitz.li on 2019/2/17.
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class L042_Trap {

    private static class Solution {
        public int trap(int[] height) {
            /**
             * 用两个数组保存每个位置对应的左右最大高度，则该位置可以保存的水滴数等于
             * 左右高度中较小的那个值减去当前位置的高度（大于0才有效）
             */
            int sum = 0;
            int n = height.length;
            if(n < 1) return 0;
            int[] maxL = new int[n];
            int[] maxR = new int[n];
            for (int i = 1; i < n; i++) {
                maxL[i] = Math.max(maxL[i-1], height[i-1]);//i左边的最大值
                maxR[n-1-i] = Math.max(maxR[n-i],height[n-i]);
            }
            for (int i = 1; i < n-1; i++) {
                int diff = Math.min(maxL[i], maxR[i]) - height[i];
                if(diff > 0){
                    sum += diff;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
