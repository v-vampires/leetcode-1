package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/25.
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 实现思路：二分查找
 */
public class L035_SearchInsert {
    private static class Solution {
        public int searchInsert(int[] nums, int target) {
            if(target <= nums[0]) return 0;
            if(target > nums[nums.length - 1]) return nums.length;
            int l = 0;
            int h = nums.length-1;
            int m = 0;
            while(l <= h){
                m = (l + h) >> 1;
                if(target == nums[m]){
                    return m;
                }else if(target < nums[m] && target > nums[m-1]){
                    return m;
                }else if(target > nums[m] && target < nums[m+1]){
                    return m+1;
                }else if(target < nums[m]){
                    h = m - 1;
                }else if(target > nums[m]){
                    l = m + 1;
                }
            }
            return -1;
        }
    }

    private static class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int h = nums.length-1;
            int m = 0;
            while(l <= h){
                m = (l + h) >> 1;
                int temp = nums[m];
                if(target == temp){
                    return m;
                }else if(target < temp){
                    h = m - 1;
                }else if(target > temp){
                    l = m + 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int i = new Solution1().searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(i);
    }
}
