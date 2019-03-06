package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/2/13.
 *
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class L059_GenerateMatrix {
    private static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int c = 1;
            int j = 0;//圈数
            while (c <= n* n){
                for (int i = j; i < n-j; i++) {//向右
                    matrix[j][i] = c++;
                }
                for (int i = j+1; i < n-j; i++) {//向下
                    matrix[i][n-j-1] = c++;
                }
                for (int i = n-j-2; i >=j; i--) {//向左
                    matrix[n-j-1][i] = c++;
                }
                for (int i = n-j-2; i > j ; i--) {//向上
                    matrix[i][j] = c++;
                }
                j++;
            }
            return matrix;
        }

    }

    public static void main(String[] args) {
        int[][] ints = new Solution().generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if(j!=0){
                    System.out.print(",\t");
                }
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }
}
