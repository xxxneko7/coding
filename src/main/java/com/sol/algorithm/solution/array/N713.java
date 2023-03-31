package com.sol.algorithm.solution.array;

import java.util.Arrays;

public class N713 {
    public static void main(String[] args) {
        System.out.println(new N713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
