package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/26.
 * 67. 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 */
public class L067_AddBinary {


    private static class Solution {
        public String addBinary(String a, String b) {
            String ans = new String();
            int la = a.length();
            int lb = b.length();
            int i = 1;
            int carry = 0;

            while(i <=la || i<=lb){
                int aindex = la - i;
                int bindex = lb - i;
                int a1 = aindex >= 0 ? a.charAt(aindex) - 48 : 0;
                int b1 = bindex >= 0 ? b.charAt(bindex) - 48 : 0;
                int sum = a1 + b1 + carry;
                carry = sum / 2;
                int tmp = sum % 2;
                ans = tmp + ans;
                i++;
            }
            if(carry > 0){
                ans = carry + ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = new Solution().addBinary("1010", "1011");
        System.out.println(s);
    }
}
