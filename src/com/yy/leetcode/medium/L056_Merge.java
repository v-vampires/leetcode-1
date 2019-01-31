package com.yy.leetcode.medium;

import com.yy.leetcode.util.Interval;

import java.util.*;

/**
 * Created by fitz.li on 2019/1/28.
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class L056_Merge {

    private static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
            LinkedList<Interval> ans = new LinkedList<>();
            for (int i = 0; i < intervals.size(); i++) {
                if(ans.isEmpty() || ans.peekLast().end < intervals.get(i).start){
                    ans.add(intervals.get(i));
                }else if(ans.peekLast().end < intervals.get(i).end){
                    ans.peekLast().end = intervals.get(i).end;
                }
            }
            return ans;
        }

    }
    //[[1,3],[2,6],[8,10],[15,18]]
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(new Interval(1,3));
        l.add(new Interval(2,6));
        l.add(new Interval(8,10));
        l.add(new Interval(15,18));
        List<Interval> merge = new Solution().merge(l);
        System.out.println(merge);
    }
}
