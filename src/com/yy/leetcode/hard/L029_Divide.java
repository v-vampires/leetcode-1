package com.yy.leetcode.hard;

/**
 * Created by fitz.li on 2019/1/24.
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 实现思路：最简单的方法就是被除数-除数，然后进行次数统计，但是此类问题容易溢出，通常做法是将正数装换为负数进行操作
 */
public class L029_Divide {

    private static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0)
                return 0;

            if (dividend == Integer.MIN_VALUE) {
                switch (divisor) {
                    case 1:
                        return Integer.MIN_VALUE;
                    case -1:
                        return Integer.MAX_VALUE;
                }
            }

            boolean positive = (dividend > 0) == (divisor > 0);
            int a = dividend < 0 ? dividend : -dividend;
            int b = divisor < 0 ? divisor : -divisor;

            if (a > b)
                return 0;

            if (a == b)
                return positive ? 1 : -1;

            int res = divisor < -1073741820 ? sub(a, b) : bitOp(a, b);

            return positive ? res : -res;
        }

        private int bitOp(int a, int b) {
            int res = 0;
            int rest = a;
            int n = 0;
            while (rest <= b) {
                n = 0;
                while (rest - (b << (n + 1)) < 0) {
                    n++;
                }
                res += 1 << n;
                rest = rest - (b << n);
            }
            return res;
        }

        private int sub(int a, int b) {
            int n = 0;
            a -= b;
            while (a < 0) {
                n++;
                a -= b;
            }
            if (a == 0)
                n++;
            return n;
        }
    }


    private static class Solution1 {
        public int divide(int dividend, int divisor) {
            if (dividend == 0)
                return 0;

            if (dividend == Integer.MIN_VALUE) {
                switch (divisor) {
                    case 1:
                        return Integer.MIN_VALUE;
                    case -1:
                        return Integer.MAX_VALUE;
                }
            }

            boolean positive = (dividend > 0) == (divisor > 0);
            int a = dividend < 0 ? dividend : -dividend;
            int b = divisor < 0 ? divisor : -divisor;

            if (a > b)
                return 0;

            if (a == b)
                return positive ? 1 : -1;
            int ret = 0;
            while (a <= 0){
                ret++;
                a -= b;
            }
            ret--;
            return positive ? ret : -ret;
        }

        private int bitOp(int a, int b) {
            int res = 0;
            int rest = a;
            int n = 0;
            while (rest <= b) {
                n = 0;
                while (rest - (b << (n + 1)) < 0) {
                    n++;
                }
                res += 1 << n;
                rest = rest - (b << n);
            }
            return res;
        }

        private int sub(int a, int b) {
            int n = 0;
            a -= b;
            while (a < 0) {
                n++;
                a -= b;
            }
            if (a == 0)
                n++;
            return n;
        }
    }

    public static void main(String[] args) {
        int divide = new Solution1().divide(Integer.MIN_VALUE, -3);
        System.out.println(divide);
    }
}
