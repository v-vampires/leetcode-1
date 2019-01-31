package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/27.
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 实现思路：1. 回溯法; 2. 递归法
 */
public class L039_CombinationSum {
    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            List<Integer> tmp = new ArrayList<>();
            backTrace(ans,tmp, candidates, target, 0);
            return ans;
        }
        private void backTrace(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int start){
            if(target <= 0){
                if(target == 0){
                    ans.add(new ArrayList<>(tmp));
                }
                return;
            }else{
                for (int i = start; i < candidates.length; i++) {
                    tmp.add(candidates[i]);
                    backTrace(ans, tmp, candidates, target - candidates[i], i);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    private static class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            List<Integer> tmp = new ArrayList<>();
            search(ans,tmp, candidates, target, 0);
            return ans;
        }
        private void search(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int start){
            if(target <= 0){
                if(target == 0) ans.add(tmp);
                return;
            }else{
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    //深拷贝
                    List<Integer> list=new ArrayList<>(tmp);
                    list.add(candidates[i]);
                    //递归运算，将i传递至下一次运算是为了避免结果重复。
                    search(ans, list, candidates, target - candidates[i], i);
                }
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution1().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}
