package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/27.
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 实现思路：回溯法
 */
public class L040_CombinationSum2 {
    private static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            backTrace(ans, new ArrayList<>(), candidates, target, 0);
            return ans;
        }
        private void backTrace(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int start){
            if(target <= 0){
                if(target == 0 && !ans.contains(tmp)) ans.add(new ArrayList<>(tmp));
                return;
            }else{
                for (int i = start; i < candidates.length; i++) {
                    if(candidates[i] > target){
                        break;
                    }
                    tmp.add(candidates[i]);
                    backTrace(ans, tmp, candidates, target - candidates[i], i+1);
                    Integer integer = tmp.get(tmp.size() - 1);
                    tmp.remove(integer);

                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}
