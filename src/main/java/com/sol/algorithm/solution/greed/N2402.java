package com.sol.algorithm.solution.greed;

import java.util.Arrays;
import java.util.Comparator;

public class N2402 {
    public static void main(String[] args) {
        int n = 3;
        String s = "[[1,20],[2,10],[3,5],[4,9],[6,8]]";
        int[][] meetings = Arrays.stream(s.substring(2, s.length() - 2).split("],\\[")).map(sub -> Arrays.stream(sub.split(",")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        N2402 solution = new N2402();
        System.out.println(solution.mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        // times[] < 5 * (10 ^ 5) * (10 ^ 5)
        long[] times = new long[n];
        int[] count = new int[n];
        Arrays.stream(meetings).sorted(Comparator.comparingInt(m -> m[0])).forEachOrdered(meeting -> {
            int startTime = meeting[0];
            int endTime = meeting[1];
            int duration = endTime - startTime;
            int room = 0;
            long minTime = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // 第一个空闲的会议室
                if (times[i] <= startTime) {
                    room = i;
                    break;
                }
                // 最早结束的会议室
                if (minTime > times[i]) {
                    minTime = times[i];
                    room = i;
                }
            }
            if (times[room] <= startTime) {
                // 会议开始前有空闲会议室，该会议室空闲时刻为会议结束的时刻
                times[room] = endTime;
            } else {
                // 会议开始前没有空闲会议室，等待最早空闲的会议室，该会议室空闲时刻增加该会议的持续时间
                times[room] += duration;
            }
            count[room]++;
        });

        int mostRoom = 0, most = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (count[i] > most) {
                most = count[i];
                mostRoom = i;
            }
        }
        return mostRoom;
    }
}
