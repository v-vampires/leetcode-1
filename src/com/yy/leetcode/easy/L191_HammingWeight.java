package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/2/20.
 */
public class L191_HammingWeight {
    private static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while(n!=0){
                count++;
                n = n&(n-1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }
}
