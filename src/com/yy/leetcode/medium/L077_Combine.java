package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/30.
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class L077_Combine {
    private static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] used = new boolean[n+1];
            dfs(ans, new ArrayList<>(), used, n, k);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, ArrayList<Integer> tmp, boolean[] used, int n, int k) {
            if(tmp.size() == k){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 1; i <= n; i++) {
                if(used[i]) continue;
                if(tmp.size() > 0 && i < tmp.get(tmp.size()-1)) continue;
                tmp.add(i);
                used[i] = true;
                dfs(ans, tmp, used, n, k);
                tmp.remove(tmp.size()-1);
                used[i] = false;
            }
        }
    }

    private static class Solution1{
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), 1, n, k);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> tmp,int start, int n, int k){
            if(k==0){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i <= n; i++) {
                tmp.add(i);
                dfs(ans, tmp, i+1, n, k-1);
                tmp.remove(tmp.size() -1 );
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution1().combine(4, 2);
        System.out.println(combine);
    }
}
