package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/13.
 * 54. 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class L054_SpiralOrder {

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if(m == 0) return new ArrayList<>();
            int n = matrix[0].length;
            List<Integer> ans = new ArrayList<>(m * n);
            int c = 0;
            int j = 0;
            loop : while(true){
                for (int i = j; i < n-j; i++) {//向右
                    ans.add(matrix[j][i]);
                    c++;
                    if(c >= m * n) break loop;
                }
                for (int i = j+1; i < m-j; i++) {//向下
                    ans.add(matrix[i][n-j-1]);
                    c++;
                    if(c >= m * n) break loop;
                }
                for (int i = n-j-2; i >= j ; i--) {//向左
                    ans.add(matrix[m-j-1][i]);
                    c++;
                    if(c >= m * n) break loop;
                }
                for (int i = m-j-2; i > j; i--) {//向上
                    ans.add(matrix[i][j]);
                    c++;
                    if(c >= m * n) break loop;
                }
                j++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {


        int[][] matrix = new int[4][4];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;

        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;

        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;
        List<Integer> integers = new Solution().spiralOrder(matrix);
        System.out.println(integers);
    }
}
