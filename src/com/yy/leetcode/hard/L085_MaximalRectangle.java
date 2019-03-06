package com.yy.leetcode.hard;

/**
 * Created by fitz.li on 2019/2/21.
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class L085_MaximalRectangle {

    private static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int[][] x = new int[matrix.length][matrix[0].length];
            int[][] y = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == '1'){
                        x[i][j] = (j < 1 ? 0 : x[i][j-1]) + matrix[i][j]-48;
                        y[i][j] = (i < 1 ? 0 : y[i-1][j]) + matrix[i][j]-48;
                    }else{
                        x[i][j] = 0;
                        y[i][j] = 0;
                    }
                    max = Math.max(x[i][j] * y[i][j], max);
                }
            }

            return max;

        }
    }

    public static void main(String[] args) {
        char[][] matrix = new char[4][5];
        matrix[0] = "10100".toCharArray();
        matrix[1] = "10111".toCharArray();
        matrix[2] = "11111".toCharArray();
        matrix[3] = "10010".toCharArray();
        System.out.println(new Solution().maximalRectangle(matrix));
        System.out.println((int)'1');
    }
}
