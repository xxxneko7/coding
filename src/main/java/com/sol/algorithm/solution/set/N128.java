package com.sol.algorithm.solution.set;

import java.util.HashSet;
import java.util.Set;

public class N128 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int cur = num + 1;
            while (set.contains(cur)) cur++;
            longest = Math.max(longest, cur - num);
        }

        return longest;
    }
}
