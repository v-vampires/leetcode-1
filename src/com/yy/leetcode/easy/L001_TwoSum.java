package com.yy.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fitz.li on 2019/1/23.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L001_TwoSum {
    /**
     * 暴力法
     */
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target){
                        ret[0] = i;
                        ret[1] = j;
                        return ret;
                    }
                }
            }

            return ret;
        }
    }

    private static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int j = target - nums[i];
                if(map.containsKey(j)){
                    ret[0] = map.get(j);
                    ret[1] = i;
                    return ret;
                }else{
                    map.put(nums[i], i);
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
