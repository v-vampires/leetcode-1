package com.yy.leetcode.hard;

/**
 * Created by fitz.li on 2019/2/20.
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class L004_FindMedianSortedArrays {

    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            if(len1 ==0 && len2 == 0) return 0;

            if(len1 == 0 || len2 ==0){
                int le = len1 != 0 ? len1 : len2;
                int[] arr = len1 != 0 ? nums1 : nums2;
                if(le % 2 == 0){
                    return (arr[le/2] + arr[le/2-1])/(double)2;
                }else{
                    return arr[le/2];
                }
            }

            int len = (len1 + len2)/2 + 1;
            int[] tmp = new int[len];
            int i =0, j =0;
            for (int k = 0; k < tmp.length; k++) {
                if(i >= len1){
                    tmp[k] = nums2[j++];
                }else if(j >= len2){
                    tmp[k] = nums1[i++];
                }else{
                    if(nums1[i] <= nums2[j]){
                        tmp[k] = nums1[i++];
                    }else{
                        tmp[k] = nums2[j++];
                    }
                }

            }
            if(len % 2 == 0 || len <=1){
                return tmp[len-1];
            }else{
                return (tmp[len-1] + tmp[len-2]) / (double)2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1,2}, new int[]{1,2,3}));
    }
}
