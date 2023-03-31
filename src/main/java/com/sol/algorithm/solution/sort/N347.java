package com.sol.algorithm.solution.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }
}
