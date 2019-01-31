package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fitz.li on 2019/1/27.
 *
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class L047_PermuteUnique {
    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();
            boolean[] visited = new boolean[nums.length];
            dfs(ans, new ArrayList<>(), nums, visited);
            return new ArrayList<>(ans);
        }
        private void dfs(Set<List<Integer>> ans, List<Integer> tmp, int[] nums, boolean[] visited){
            if(tmp.size() == nums.length){
                ans.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if(visited[i]) continue;
                tmp.add(nums[i]);
                visited[i] = true;
                dfs(ans, tmp,nums, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1,1,1,1,1,2,2});
        System.out.println(lists.size());
    }

}
