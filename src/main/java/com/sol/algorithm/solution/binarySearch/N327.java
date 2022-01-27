package com.sol.algorithm.solution.binarySearch;

import java.util.Arrays;

/**
 * 327. 区间和的个数
 */
public class N327 {
    public static void main(String[] args) {
        System.out.println(new N327().countRangeSum(new int[]{2147483647,-2147483648,-1,0}, -1, 0));
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
//        Arrays.sort(preSums);
        return countRangeSum(0, preSums.length - 1);
    }

    /**
     * 计算 [l, r] 内 nums 满足条件的区间和个数
     *
     * @param l 左边界
     * @param r 右边界
     * @return 满足条件的区间和个数
     */
    private int countRangeSum(int l, int r) {
        if (l == r) return 0;
        // 划分为两个【升序子数组】 preSums[k], k ∈ [l, m] 和 preSums[t], t ∈ [m+1, r]
        int m = (l + r) / 2;
        int count = countRangeSum(l, m) + countRangeSum(m + 1, r);
        // 计算符合条件的下标对，使得 lower <= preSums[t] - preSums[k] <= upper, t ∈ [i, j)
        int i = m + 1, j;
        for (int k = l; k <= m; k++) {
            while (i <= r && preSums[i] - preSums[k] < lower) i++;
            j = i;
            while (j <= r && preSums[j] - preSums[k] <= upper) j++;
            count += (j - i);
        }
        if (l == 0 && r == preSums.length - 1) {
            return count;
        }
        // 对区间 [l, r] 内的前缀和按升序排序
        int len = r - l + 1;
        // p1 ∈ [l, m], p2 ∈ [m+1, r]
        int p1 = l, p2 = m + 1;
        long[] sorted = new long[len];
        for (int k = 0; k < len; k++) {
            if (p1 > m) sorted[k] = preSums[p2++];
            else if (p2 > r) sorted[k] = preSums[p1++];
            else sorted[k] = preSums[p1] < preSums[p2] ? preSums[p1++] : preSums[p2++];
        }
        System.arraycopy(sorted, 0, preSums, l, len);
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
