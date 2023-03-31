package com.sol.algorithm.solution.heap;

import java.util.*;

public class N621 {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        System.out.println(solution.leastInterval("AAAAAABCDEFG".toCharArray(), 2));
    }

    private static class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> taskToCount = new HashMap<>(tasks.length);
            for (char c : tasks) taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(taskToCount.size(), Comparator.reverseOrder());
            taskToCount.values().forEach(priorityQueue::offer);
            int least = 0;
            List<Integer> temp = new ArrayList<>(n + 1);
            while (!priorityQueue.isEmpty()) {
                temp.clear();
                int i = 0;
                for (; i < n + 1; i++) {
                    if (priorityQueue.isEmpty()) break;
                    int count = priorityQueue.poll() - 1;
                    if (count > 0) temp.add(count);
                }
                temp.forEach(priorityQueue::offer);
                if (!priorityQueue.isEmpty()) least += n + 1;
                else least += i;
            }
            return least;
        }
    }
}
