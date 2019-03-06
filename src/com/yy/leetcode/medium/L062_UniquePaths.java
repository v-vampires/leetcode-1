package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fitz.li on 2019/1/30.
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 实现思路：动态规划：由于只能向右和向下，那么当走到当前格=走到左边的路径数+走到右边的路径数
 */
public class L062_UniquePaths {

    private static class Solution {
        public int uniquePaths(int m, int n) {
            int[] nums = new int[m -1 + n -1];
            for (int i = 0; i < m - 1; i++) {
                nums[i] = 1;
            }
            for (int i = m -1; i < nums.length; i++) {
                nums[i] = 2;
            }
            Set<List<Integer>> ans = new HashSet<>();
            boolean[] used = new boolean[nums.length];
            dfs(ans, new ArrayList<>(), nums, used);
            return ans.size();
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

    private static class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][] roadNum = new int[n][m];
            roadNum[0][0] = 1;
            for (int i = 1; i < m; i++) {
                roadNum[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                roadNum[i][0] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    roadNum[i][j] = roadNum[i-1][j] + roadNum[i][j-1];
                }
            }
            return roadNum[n-1][m-1];
        }
    }

    private static class Solution2 {
        public int uniquePaths(int m, int n) {
            int[][] roadNum = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(i > 0 && j>0){
                        roadNum[i][j] = roadNum[i-1][j] + roadNum[i][j-1];
                    }else{
                        roadNum[i][j] = 1;
                    }
                }
            }
            return roadNum[n-1][m-1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(7,3));
    }
}
