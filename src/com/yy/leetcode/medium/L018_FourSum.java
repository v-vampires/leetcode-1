package com.yy.leetcode.medium;

import java.util.*;

/**
 * Created by fitz.li on 2019/2/10.
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class L018_FourSum {
    private static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> ans = new HashSet<>();
            dfs(ans, new ArrayList<>(), nums, 0, target);
            return new ArrayList<>(ans);
        }

        private void dfs(Set<List<Integer>> ans, ArrayList<Integer> tmp, int[] nums, int start, int target) {
            if(tmp.size() == 4 && target == 0){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if(tmp.size() >=4 || (target >=0 && target < nums[i])) break;
                tmp.add(nums[i]);
                target = target - nums[i];
                dfs(ans, tmp, nums, i+1, target);
                tmp.remove(tmp.size() - 1);
                target = target + nums[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
