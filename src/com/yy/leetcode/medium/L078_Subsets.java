package com.yy.leetcode.medium;

import java.util.*;

/**
 * Created by fitz.li on 2019/2/17.
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class L078_Subsets {
    /**
     * BFS实现
     * []->[],[1]->[],[1],[2],[1,2]->
     */
    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for (int n : nums) {
                int size = ans.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> integers = ans.get(i);
                    ArrayList<Integer> ints = new ArrayList<>(integers);
                    ints.add(n);
                    ans.add(ints);
                }
            }
            return ans;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1,2,3}));
    }
}
