package com.sol.algorithm.solution.binarySearch;

/**
 * 327. 区间和的个数
 */
public class N327 {
    public static void main(String[] args) {
        System.out.println(new N327().countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
    }

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
        int n = nums.length;
        // 前缀和 数组
        preSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
        return countRangeSum(0, preSums.length - 1);
    }

    /**
     * 计算 {@code preSum[p], p ∈ [l, r]} 内满足条件的区间和个数
     *
     * @param l 左边界
     * @param r 右边界
     * @return 满足条件的区间和个数
     */
    private int countRangeSum(int l, int r) {
        if (l == r) return 0;
        // 划分为两个【升序子数组】
        int m = (l + r) / 2;
        return countRangeSum(l, m) + countRangeSum(m + 1, r) + countRangeSumOfMerge(l, m, r);
    }

    /**
     * 计算 {@code preSum[p1], i1 ∈ [l, m]} 与 {@code preSum[p2], i2 ∈ [m+1, r]} 合并后满足条件的区间和个数
     *
     * @param l 左边界
     * @param m 中点
     * @param r 右边界
     * @return 满足条件的区间和个数
     */
    private int countRangeSumOfMerge(int l, int m, int r) {
        int i = m + 1, j = m + 1;
        int count = 0;
        long[] sorted = new long[r - l + 1];
        int s = 0, p1 = l, p2 = m + 1;
        while (p1 <= m) {
            // 1. 计算符合条件的下标对，使得 lower <= preSums[p2] - preSums[p1] <= upper, p2 ∈ [i, j)
            long lowerOfP2 = lower + preSums[p1], upperOfP2 = upper + preSums[p1];
            while (i <= r && preSums[i] < lowerOfP2) i++;
            while (j <= r && preSums[j] <= upperOfP2) j++;
            count += (j - i);
            // 2. 对区间 [l, r] 内的前缀和按升序排序
            while (p2 <= r && preSums[p2] < preSums[p1]) sorted[s++] = preSums[p2++];
            sorted[s++] = preSums[p1++];
        }
        while (p2 <= r) {
            sorted[s++] = preSums[p2++];
        }
        System.arraycopy(sorted, 0, preSums, l, sorted.length);
        return count;
    }

    /**
     * 前缀和数组
     */
    long[] preSums;
    /**
     * 下界
     */
    int lower;
    /**
     * 上界
     */
    int upper;
}
