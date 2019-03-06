package com.yy.leetcode.medium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by fitz.li on 2019/2/23.
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 实现思路：动态规划
 * 二叉搜索树就是二叉排序树。也就是左子树<父节点<右子树
 * G(n)表示n个节点的二叉树个数=以1为根节点的二叉树个数f(1)+以2为根节点的二叉树个数f(2)+...+以n为根节点的二叉树个数f(n)
 * f(1) = 左子树G(0) * G(n-1)
 * f(2) = 左子树G(1) * G(n-1-1)
 * f(3) = 左子树G(2) * G(n-2-1)
 * ....
 * f(n) = 左子树G(n-1) * G(0)
 *
 *
 * G(n) = G(0)*G(n-1)+G(1)*G(n-1-1)+G(2)*G(n-2-1)+...G(n-1)*G(0)
 */

public class L096_NumTrees {

    private static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i-1-j];
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(new Solution().numTrees(3));
    }

}
