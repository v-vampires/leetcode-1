package com.yy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fitz.li on 2019/1/25.
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 实现思路：回溯法，暴力法，要注意跳过重复的
 */
public class L015_ThreeSum {

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(ret, new ArrayList<>(), nums, 0, 0);
            return ret;
        }
        private void backTrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int sum, int start){
            if(tmpList.size() == 3){
                ArrayList<Integer> integers = new ArrayList<>(tmpList);
                if(sum == 0 && !list.contains(integers)){
                    list.add(integers);
                }
                return;
            }else{
                for (int i = start; i < nums.length; i++) {
                    int num = nums[i];
                    tmpList.add(num);
                    sum += num;
                    backTrack(list, tmpList, nums, sum, i + 1);
                    Integer integer = tmpList.get(tmpList.size() - 1);
                    tmpList.remove(integer);
                    sum -= integer;
                }
            }
        }
    }


    private static class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if(nums[i] > 0){
                    break;
                }
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                    int low = i + 1;
                    int hi = nums.length - 1;
                    int sum = 0 - nums[i];
                    while(low < hi){
                        if(nums[low] + nums[hi] == sum){
                            ret.add(Arrays.asList(nums[i], nums[low], nums[hi]));
                            //跳过相同的
                            while (low < hi && nums[low] == nums[low + 1]) low++;
                            while (low < hi && nums[hi] == nums[hi-1]) hi--;
                            low++;
                            hi--;
                        }else if(nums[low] + nums[hi] < sum){
                            while(low < hi && nums[low] == nums[low + 1]) low++;
                            low++;
                        }else{
                            while(low < hi && nums[hi] == nums[hi - 1]) hi--;
                            hi--;
                        }
                    }
                }
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution1().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
