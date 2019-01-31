package com.yy.leetcode.medium;

import java.util.Arrays;

/**
 * Created by fitz.li on 2019/1/25.
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class L034_SearchRange {

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = -1;
            int end = -1;
            int i = 0;
            int j = nums.length - 1;
            int index = -1;
            while(i <= j){
                int m = (i+j) >> 1;
                int num = nums[m];
                if(target == num){
                    index = m;
                    break;
                }
                if(target < num){
                    j = m -1;
                }
                if(target > num){
                    i = m + 1;
                }
            }
            if(index != -1){
                start = index;
                while(start >= 0 &&nums[start] == target){
                    start--;
                }
                start = start + 1;
                end = index;
                while (end <= nums.length -1 && nums[end] == target){
                    end++;
                }
                end = end -1;
            }
            return new int[]{start, end};
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
