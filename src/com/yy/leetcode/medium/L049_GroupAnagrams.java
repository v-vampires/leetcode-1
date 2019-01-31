package com.yy.leetcode.medium;

import java.util.*;

/**
 * Created by fitz.li on 2019/1/23.
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class L049_GroupAnagrams {

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            if(strs == null || strs.length <= 1){
                ret.add(Arrays.asList(strs));
                return ret;
            }
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String newStr = String.valueOf(chars);
                List<String> strings = map.get(newStr);
                if(strings == null){
                    strings = new ArrayList<>();
                    map.put(newStr, strings);
                    ret.add(strings);
                }
                strings.add(str);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
