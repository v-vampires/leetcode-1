package com.yy.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/29.
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class L051_SolveNQueens {

    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            int[] result = new int[n];
            List<List<String>> ans= new ArrayList<>();
            calcNQueens(ans, result, 0, n);
            return ans;
        }

        private void calcNQueens(List<List<String>> ans, int[] result, int row, int n) {
            if(row == n){
                List<String> tmp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if(result[i] == j){//有棋子
                            System.out.print("Q ");
                            sb.append("Q");
                        }else{
                            sb.append(".");
                            System.out.print(". ");
                        }
                    }
                    System.out.println();
                    tmp.add(sb.toString());
                }
                System.out.println();
                ans.add(tmp);
                return;
            }
            for (int col = 0; col < n; col++) {
                if(isOK(row, col, result, n)){
                    result[row] = col;
                    calcNQueens(ans, result, row+1, n);
                }
            }
        }

        private boolean isOK(int row, int col, int[] result, int n){
            int left = col - 1, right = col + 1;
            for (int preRow = row - 1; preRow >=0 ; preRow--) {
                if(result[preRow] == col) return false; //同列
                if(left >= 0 && result[preRow] == left) return false;
                if(right < n && result[preRow] == right) return false;
                left--;
                right++;
            }
            return true;
        }

    }


    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        System.out.println(lists);
    }
}
