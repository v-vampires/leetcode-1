package com.yy.leetcode.easy;

import java.util.Arrays;

/**
 * Created by fitz.li on 2019/1/26.
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 实现思路：反向迭代，保留进位。优化点，如果进位为0，就不再需要继续迭代，直接copy剩余的数组就可以了
 */
public class L066_PlusOne {

    private static class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int k=0;
            int[] ret = new int[digits.length];
            for (int i = digits.length - 1; i >=0; i--) {
                int digit = digits[i];
                k = (i == digits.length - 1) ? 1 : 0;
                ret[i] = (carry + digit + k) % 10;
                carry = (carry + digit + k) / 10;
            }
            if(carry != 0){
                int[] ints = new int[digits.length + 1];
                ints[0] = carry;
                System.arraycopy(ret, 0, ints, 1, ret.length);
                return ints;
            }else{
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().plusOne(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(ints));
    }
}
