package com.sol.algorithm.solution.dp;

/**
 * 打家劫舍
 */
public class N198 {
    public static void main(String[] args) {
        System.out.println(new N198().rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        int rob = 0, unrob = 0;
        for (int num : nums) {
            int preRob = rob, preUnrob = unrob;
            rob = preUnrob + num;
            unrob = Math.max(preRob, preUnrob);
        }
        return Math.max(rob, unrob);
    }
}
