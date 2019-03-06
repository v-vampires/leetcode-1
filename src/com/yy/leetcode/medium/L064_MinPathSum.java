package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/12.
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 实现思路：动态规划；因为只能向右或者向下，所以走到当前格的步数=min(上边一格的步数,左边一格的步数)+当前格需要的步数
 *
 */
public class L064_MinPathSum {

    private static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            if(m == 0) return 0;
            int n = grid[0].length;
            int[][] step = new int[grid.length][grid[0].length];
            for (int i = 0; i < m; i++) {
                for (int j=0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        step[i][j] = grid[i][j];
                    } else {
                        int up = i - 1 < 0 ? Integer.MAX_VALUE : step[i - 1][j];
                        int left = j - 1 < 0 ? Integer.MAX_VALUE : step[i][j - 1];
                        step[i][j] = Math.min(left, up) + grid[i][j];
                    }
                }
            }
            return step[m-1][n-1];
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;

        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;

        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(new Solution().minPathSum(grid));

    }

}
