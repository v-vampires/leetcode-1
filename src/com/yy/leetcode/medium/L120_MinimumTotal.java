package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fitz.li on 2019/2/20.
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class L120_MinimumTotal {
    private static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle == null || triangle.size() <1) return 0;
            int[] dp = new int[triangle.get(0).size()]; //f[i,j] = a[i,j] + min(f[i-1,j],f[i-1,j-1])
            dp[0] = triangle.get(0).get(0);
            if(triangle.size() == 1) return dp[0];
            int retMin = Integer.MAX_VALUE;
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> row = triangle.get(i);
                int[] tmp = new int[row.size()];
                for (int j = 0; j < row.size(); j++) {
                    tmp[j] = Math.min(j < dp.length ? dp[j] : Integer.MAX_VALUE, j-1 >=0 ? dp[j-1] : Integer.MAX_VALUE) + row.get(j);
                    if(i == triangle.size()-1)retMin = Math.min(tmp[j], retMin);
                }
                dp = tmp;

            }
            return retMin;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(new Solution().minimumTotal(list));
    }
}
