package com.yy.leetcode.easy;

/**
 * Created by fitz.li on 2019/1/26.
 * 38. 报数
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *

 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 实现思路：暴力法
 */
public class L038_CountAndSay {
    private static class Solution {
        public String countAndSay(int n) {
            if(n == 1) return "1";
            String s = "1";
            for (int i = 2; i <= n; i++) {
                char c = s.charAt(0);
                char[] chars = s.toCharArray();
                int count = 0;
                String tmp = new String();
                for (char aChar : chars) {
                    if(c == aChar){
                        count++;
                    }else{
                        tmp += count;
                        tmp += c;
                        c = aChar;
                        count = 1;
                    }
                }
                tmp += count;
                tmp += c;

                s = tmp;
            }
            return s;
        }
    }

    public static void main(String[] args) {
        String s = new Solution().countAndSay(5);
        System.out.println(s);

    }
}
