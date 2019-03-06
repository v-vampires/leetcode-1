package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/31.
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class L069_MySqrt {
    private static class Solution {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            if(x <=3) return 1;
            int left = 0;
            int right = x;
            while(left < right){
                int mid = left + (right - left) / 2;
                if((long)mid * mid == x){
                    return mid;
                }
                if(((long)mid * mid) > x){
                    if((long)(mid - 1) * (mid - 1) > x){
                        right = mid - 1;
                    }else{
                        return mid - 1;
                    }
                }
                if((long)mid * mid < x){
                    if((mid + 1) * (mid + 1) <x){
                        left = mid+ 1;
                    }else if((long)(mid + 1) * (mid + 1) == x){
                        return mid + 1;
                    }else {
                        return mid;
                    }
                }
            }
            return 0;
        }
    }

    private static class Solution1 {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            if(x <=3) return 1;
            int left = 0;
            int right = x;
            int ans = x;
            while( !(((long)ans * ans)<=x && (long)(ans + 1) * (ans + 1) > x )){
                if((long)ans * ans <= x){
                    left = ans;
                }else{
                    right = ans;
                }
                ans = left + (right - left) / 2;

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().mySqrt(
                2147395599));
    }
}
