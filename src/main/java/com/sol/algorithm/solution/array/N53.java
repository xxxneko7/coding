package com.sol.algorithm.solution.array;

public class N53 {
    public int maxSubArray(int[] nums) {
        int max = 0, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        N53 solution = new N53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}
