package com.yy.leetcode.medium;

import java.util.Arrays;

/**
 * Created by fitz.li on 2019/2/20.
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 */
public class L338_CountBits {
    /**
     * 1. 参考http://www.cnblogs.com/xiaxj/p/9692902.html
     * 2. dp[i] = dp[i/2] + (i&1)
     */
    private static class Solution {
        public int[] countBits(int num) {
            int[] dp = new int[num+1];
            dp[0] = 0;
            for (int i = 1; i <= num; i++) {
                if(i%2 == 0){//偶数最后一位是0，所以其1的个数等于i>>1对应的个数
                    dp[i] = dp[i/2];
                }else{//
                    dp[i] = dp[i-1] + 1;
                }
            }
            return dp;
        }

    }


    private static class Solution1 {
        public int[] countBits(int num) {
            int[] ret = new int[num+1];
            for (int i = 0; i <= num; i++) {
                ret[i] = countOf1(i);
            }
            return ret;
        }

        private int countOf1(int n){
            int count = 0;
            while(n > 0){
                count++;
                n = n & (n-1);//把一个整数减去1和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中的最右一个1变成0
            }
            return count;
        }
    }




    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}
