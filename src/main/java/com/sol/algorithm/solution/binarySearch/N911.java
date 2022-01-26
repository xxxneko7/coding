package com.sol.algorithm.solution.binarySearch;

import java.util.*;

/**
 * 911. 在线选举
 */
public class N911 {
    class TopVotedCandidate {
        /**
         * topAtTimes[i] 为 times[i] 时刻得票数最多的候选人
         */
        List<Integer> topAtTimes;
        /**
         * 时刻
         */
        int[] times;

        /**
         * 第 i 张票在 times[i] 时投票给候选人 persons[i]
         *
         * @param persons 候选人
         * @param times   时刻
         */
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            this.topAtTimes = new ArrayList<>();
            // 候选人 -> 得票数
            Map<Integer, Integer> personToVotes = new HashMap<>();
            personToVotes.put(-1, -1);
            int top = -1;
            for (int i = 0; i < times.length; i++) {
                // 获得第 i 票的候选人得票数 +1
                int person = persons[i];
                int votes = personToVotes.getOrDefault(person, 0) + 1;
                personToVotes.put(person, votes);
                if (votes >= personToVotes.get(top)) {
                    top = person;
                }
                topAtTimes.add(top);
            }
        }

        /**
         * 返回在时刻 t 在选举中领先的候选人的编号。在 t 时刻投出选票也需要统计；平局时，返回最近获得投票的候选人
         *
         * @param t 时刻
         * @return 候选人编号
         */
        public int q(int t) {
            // 【二分查找】 满足 times[l] <= t 时最大的 l
            int l = 0, r = times.length - 1;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (times[m] > t) {
                    r = m - 1;
                } else if (times[m] < t) {
                    l = m;
                } else {
                    l = m;
                    break;
                }
            }
            return topAtTimes.get(l);
        }
    }
}
