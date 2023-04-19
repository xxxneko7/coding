package com.sol.algorithm.solution.binarysearch;

import java.util.Arrays;

public class N167 {
    public static void main(String[] args) {
        N167 solution = new N167();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum < target) l++;
            else r--;
        }
        return new int[]{-1, -1};
    }
}
