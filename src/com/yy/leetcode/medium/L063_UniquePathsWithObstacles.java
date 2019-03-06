package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/12.
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class L063_UniquePathsWithObstacles {
    private static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            if (m == 0) return 0;
            if(obstacleGrid[0][0] == 1) return 0;
            int n = obstacleGrid[0].length;
            int[][] road = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        road[i][j] = 1;
                    } else if (i == 0 && j > 0) {
                        road[i][j] = road[i][j - 1] == 0 ? 0 : obstacleGrid[i][j] == 1 ? 0 : 1;
                    } else if (i > 0 && j == 0) {
                        road[i][j] = road[i - 1][j] == 0 ? 0 : obstacleGrid[i][j] == 1 ? 0 : 1;
                    } else {
                        road[i][j] = obstacleGrid[i][j] == 1 ? 0 : road[i-1][j] + road[i][j-1];
                    }
                }
            }
            return road[m-1][n-1];
        }
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[0][0] = 0;
        obstacleGrid[0][1] = 0;
        obstacleGrid[0][2] = 0;

        obstacleGrid[1][0] = 0;
        obstacleGrid[1][1] = 1;
        obstacleGrid[1][2] = 0;

        obstacleGrid[2][0] = 0;
        obstacleGrid[2][1] = 0;
        obstacleGrid[2][2] = 0;
        int i = new Solution().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
}
