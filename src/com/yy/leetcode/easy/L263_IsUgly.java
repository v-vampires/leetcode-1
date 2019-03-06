package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/2/23.
 */
public class L263_IsUgly {

    private static class Solution {
        public boolean isUgly(int num) {
            if(num == 0) return false;
            while(num != 1){
                if(num % 2 == 0){
                    num = num / 2;
                }else if(num % 3 == 0){
                    num = num / 3;
                }else if(num % 5 == 0){
                    num = num / 5;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(55));
    }
}
