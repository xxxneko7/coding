package com.sol.algorithm.solution.binarySearch;

import java.util.Arrays;

public class N1760 {
    public static void main(String[] args) {
        N1760 solution = new N1760();
        int[] nums;
        int maxOperations;

        nums = new int[]{9};
        maxOperations = 2;
        System.out.println(solution.minimumSize(nums, maxOperations));

        nums = new int[]{2, 4, 8, 2};
        maxOperations = 4;
        System.out.println(solution.minimumSize(nums, maxOperations));

        nums = new int[]{7, 17};
        maxOperations = 2;
        System.out.println(solution.minimumSize(nums, maxOperations));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        this.nums = nums;
        int max = Arrays.stream(nums).max().orElse(1);
        int min = 1;

        while (min < max) {
            int mid = (min + max) >> 1;
            if (calOperations(mid) <= maxOperations) max = mid;
            else min = mid + 1;
        }

        return min;
    }

    private int calOperations(int size) {
        int operations = 0;
        for (int num : nums) {
            if (num > size) {
                operations += (num - 1) / size;
            }
        }
        return operations;
    }

    int[] nums;
}
