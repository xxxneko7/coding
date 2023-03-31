package com.sol.algorithm.solution.array;

public class N238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int r = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i] * r;
            r = r * nums[i];
        }
        return res;
    }
}
