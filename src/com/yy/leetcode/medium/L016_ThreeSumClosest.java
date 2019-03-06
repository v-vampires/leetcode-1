package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/6.
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class L016_ThreeSumClosest {
    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            List<Integer> ans = new ArrayList<>();
            dfs(ans, nums, 0, target, 0);
            int min = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;
            for (Integer an : ans) {//an是target与三数和的差
                int i = target - an;//三个数之和
                if(Math.abs(an) < min){//
                    min = Math.abs(an);
                    result = i;
                }
            }
            return result;
        }

        private void dfs(List<Integer> ans, int[] nums, int start, int target, int length) {
            if(length == 3){
                ans.add(target);
                return;
            }
            for (int j = start; j < nums.length; j++) {
                target = target - nums[j];
                length++;
                dfs(ans, nums, j+1, target, length);
                target = target + nums[j];
                length--;
            }
        }
    }

    public static void main(String[] args) {
        int i = new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }
}
