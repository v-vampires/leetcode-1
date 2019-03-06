package com.yy.leetcode.medium;

import java.util.Arrays;

/**
 * Created by fitz.li on 2019/2/16.
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 12345 -> 12354
 * 12354 -> 12435
 * 12543 -> 13245
 * 15432 -> 21345
 */
public class L031_NextPermutation {
    private static class Solution {
        public void nextPermutation(int[] nums) {
            boolean f = true;
            for (int i = nums.length - 1; i > 0 & f; i--) {
                for (int j = i-1; j >=0 ; j--) {
                    if(nums[i] > nums[j]){
                        swap(nums, i,j);
                        sort(nums, j+1);
                        f = false;
                        break;
                    }
                }
            }
            if(f) Arrays.sort(nums);
        }

        private void sort(int[] nums, int start){
            Arrays.sort(nums, start, nums.length);
        }

        private void swap(int[] nums,int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
