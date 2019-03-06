package com.yy.leetcode.hard;

import com.yy.leetcode.util.Interval;

import java.util.*;

/**
 * Created by fitz.li on 2019/2/10.
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class L057_Insert {
    private static class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            intervals.add(newInterval);
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    int n = o1.start - o2.start;
                    if(n == 0) n = o1.end - o2.end;
                    return n;
                }
            });

            List<Interval> ans = new ArrayList<>();
            for (Interval interval : intervals) {
                if(ans.isEmpty()){
                    ans.add(interval);
                }else{
                    Interval last = ans.get(ans.size() - 1);
                    if(interval.start <= last.end){
                        ans.remove(last);
                        int s = Math.min(interval.start, last.start);
                        int e = Math.max(interval.end, last.end);
                        ans.add(new Interval(s, e));
                    }else{
                        ans.add(interval);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(new Interval(1,3));
        l.add(new Interval(6,9));
        List<Interval> insert = new Solution().insert(l, new Interval(2,5));
        System.out.println(insert);
    }
}
