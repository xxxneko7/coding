package com.sol.algorithm.solution;

import java.util.*;

/**
 * 1851. 包含每个查询的最小区间
 */
public class N1851 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(new N1851().minInterval(intervals, queries)));
    }

    /**
     * 第 j 个查询的答案是满足 left_i <= queries[j] <= right_i 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1
     *
     * @param intervals 区间
     * @param queries   查询
     * @return 答案
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Event> events = new ArrayList<>();
        for (int[] interval : intervals) {
            int len = interval[1] - interval[0] + 1;
            events.add(new Event(interval[0], len, 1));
            events.add(new Event(interval[1], len, -1));
        }
        for (int i = 0; i < queries.length; i++) {
            events.add(new Event(queries[i], i, 0));
        }
        events.sort((e1, e2) -> e1.pos == e2.pos ? e2.type - e1.type : e1.pos - e2.pos);

        int[] ans = new int[queries.length];
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (Event event : events) {
            if (event.type == 1) {
                sortedMap.put(event.len, sortedMap.getOrDefault(event.len, 0) + 1);
            } else if (event.type == -1) {
                int count = sortedMap.get(event.len);
                if (count == 1) sortedMap.remove(event.len);
                else sortedMap.put(event.len, count - 1);
            } else {
                // query 事件的 len 保存原始查询的下标
                ans[event.len] = sortedMap.firstKey();
            }
        }

        return ans;
    }

    class Event {
        int pos;
        int len;
        int type;

        Event(int pos, int len, int type) {
            this.pos = pos;
            this.len = len;
            this.type = type;
        }
    }


}
