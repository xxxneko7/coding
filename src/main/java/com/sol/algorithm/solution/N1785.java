package com.sol.algorithm.solution;

import java.util.Arrays;

public class N1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = goal - Arrays.stream(nums).asLongStream().sum();
        sum = Math.abs(sum);
        return (int) ((sum + limit - 1) / limit);
    }

    public static void main(String[] args) {
        N1785 solution = new N1785();
        int[] nums = {1, -10, 9, 1};
        int limit = 100, goal = 0;
        System.out.println(solution.minElements(nums, limit, goal));
    }
}
