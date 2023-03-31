package com.sol.algorithm.solution.dp;

import java.util.Arrays;

public class N416 {
    /**
     * 分割等和子集
     *
     * @param nums 非空 正整数数组
     * @return 是否能分割成两个等和子集
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (max > target) return false;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
