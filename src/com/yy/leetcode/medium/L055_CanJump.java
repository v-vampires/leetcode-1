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
            if(nums.length == 1) return true;
            if(nums[0] == 0) return false;
            int i = 0;
            while(i < nums.length - 1){
                int num = nums[i];
                i = i + num;
                if(i >= nums.length){
                    return true;
                }
                if(num == 0){
                    for (int j = i-1; j >=0 ; j--) {
                        if(j + nums[j] > i){
                            break;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        boolean b = new Solution().canJump(new int[]{2,5,0,0});
        System.out.println(b);
    }
}
