package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/16.
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class L033_Search {

    private static class Solution {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0) return -1;
            int mid = nums.length-1;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    mid = i;
                    break;
                }
            }

            if(target > nums[0]){//在前半段
                return binarySearch(nums, 0, mid,target);
            }else if(target < nums[0]){//在后半段
                return binarySearch(nums, mid+1, nums.length-1,target);
            }else{
                return 0;
            }
        }

        private int binarySearch(int[] nums, int s, int e, int target){

            while(s <= e){
                int mid = (s + e)/2;
                if(target > nums[mid]){
                    s = mid+1;
                }else if(target < nums[mid]){
                    e = mid-1;
                }else {
                    return mid;
                }
            }

            return -1;

        }
    }

    private static class Solution1 {
        public int search(int[] nums, int target){
            if(nums == null || nums.length == 0) return -1;
            int low = 0;
            int hi = nums.length - 1;
            while(low <= hi){
                int mid = low + (hi - low)/2;
                if(target == nums[low]) return low;
                if(target == nums[hi]) return hi;
                if(target == nums[mid]) return mid;
                if(nums[low] < nums[mid]){
                    if(target < nums[mid] && target > nums[low]){
                        hi = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }else{
                    if(target > nums[mid] && target < nums[hi]){
                        low = mid + 1;
                    }else{
                        hi = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

        public static void main(String[] args) {
        System.out.println(new Solution1().search(new int[]{4,5,6,7,0,1,2}, 8));
    }
}
