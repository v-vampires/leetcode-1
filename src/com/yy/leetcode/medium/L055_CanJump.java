package com.yy.leetcode.medium;

/**
 * Created by fitz.li on 2019/1/29.
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class L055_CanJump {
    private static class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length == 0 || nums.length == 1) return true;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0){
                    int j = i-1;
                    boolean can = false;
                    while(j>=0){
                        if(nums[j] + j > i || (nums[j] + j == i && i == nums.length -1 )){
                            can = true;
                            break;
                        }
                        j--;
                    }
                    if(!can){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class Solution1 {
        public boolean canJump(int[] nums) {
            if(nums.length == 0 || nums.length == 1) return true;
            int lastIndex = nums.length - 1;
            for (int i = lastIndex-1; i >=0 ; i--) {
                if(nums[i] + i >= lastIndex){
                    lastIndex = i;
                }
            }
            return lastIndex == 0;
        }
    }

    public static void main(String[] args) {
        boolean b = new Solution1().canJump(new int[]{2,0,0});
        System.out.println(b);
    }
}
