package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/23.
 * 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 实现思路：[1]->[2,1],[1,2]->[3,2,1],[2,3,1],[2,1,3],[3,1,2],[1,3,2],[1,2,3]; 即增加一个元素则在现有的序列的每个位置上插入形成新序列
 */
public class L046_Permute {
    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if(nums.length == 0) return null;
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[0]);
            ret.add(sub);
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                List<List<Integer>> t = new ArrayList<>();
                for (List<Integer> ins : ret) {
                    for (int j = 0; j < ins.size() + 1; j++) {
                        ArrayList<Integer> tmp = new ArrayList<>(ins);
                        tmp.add(j, num);
                        t.add(tmp);
                    }
                }
                ret = t;
            }
            return ret;
        }
    }

    private static class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            if(nums.length == 0) return null;
            List<List<Integer>> ret = new ArrayList<>();
            backTrack(ret, new ArrayList<>(), nums);
            return ret;
        }

        private void backTrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums){
            if(tmpList.size() == nums.length){
                list.add(new ArrayList<>(tmpList));
                return;
            }else{
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    if(tmpList.contains(num)) continue;
                    tmpList.add(num);
                    backTrack(list, tmpList, nums);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution1().permute(new int[]{1, 2, 3});
        System.out.println(permute);

    }
}
