package com.sol.algorithm.solution.binarySearch;

/**
 * 327. 区间和的个数
 */
public class N327 {
    /**
     * 求数组 nums 中，值位于范围 [lower, upper] 内的 区间和的个数
     *
     * @param nums  数组
     * @param lower 下界
     * @param upper 上界
     * @return 区间和的个数
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        int count = 0;

        return count;
    }

    private boolean valid(int val) {
        return lower <= val && val <= upper;
    }

    int lower;
    int upper;
}
