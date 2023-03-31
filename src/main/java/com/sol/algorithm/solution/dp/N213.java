package com.sol.algorithm.solution.dp;

/**
 * 打家劫舍 圈 计算两轮 1.不偷最后一家; 2.不偷第一家
 */
public class N213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        int rob, unrob, money;
        // 1.不偷最后一家
        rob = nums[0];
        unrob = 0;
        for (int i = 1; i < n - 1; i++) {
            int tRob = rob, tUnrob = unrob;
            rob = tUnrob + nums[i];
            unrob = Math.max(tUnrob, tRob);
        }
        money = Math.max(rob, unrob);
        // 2.不偷第一家
        rob = nums[1];
        unrob = 0;
        for (int i = 2; i < n; i++) {
            int tRob = rob, tUnrob = unrob;
            rob = tUnrob + nums[i];
            unrob = Math.max(tUnrob, tRob);
        }
        money = Math.max(money, Math.max(rob, unrob));
        return money;
    }
}
