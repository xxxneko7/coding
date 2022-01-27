package com.sol.algorithm.solution.binarySearch;

/**
 * 327. 区间和的个数
 */
public class N327 {
    public static void main(String[] args) {
        System.out.println(new N327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
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
        this.n = nums.length;
        // 前缀和 数组
        preSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
        return countRangeSum(0, n - 1);
    }

    private int countRangeSum(int l, int r) {
        if (l == r) return 0;
        // 划分为两个【升序子数组】
        int m = (l + r) / 2;
        int count = countRangeSum(l, m) + countRangeSum(m + 1, r);
        // 计算符合条件的【下标对】
        for (int k = l; k <= m; k++) {
            int i = m + 1;
            while (preSums[i] - preSums[k] < lower && i <= r) i++;
            int j = i;
            while (preSums[j] - preSums[k] <= upper && j <= r) j++;
            count += (j - i);
        }
        if (l == 0 && r == n - 1) {
            return count;
        }
        // 对区间 [l, r] 内的前缀和按升序排序
        int len = r - l + 1;
        int p1 = l, p2 = m + 1;
        long[] sorted = new long[len];
        for (int k = 0; k < len - 1; k++) {
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
     * 数组 {@code nums} 长度
     */
    int n;
    /**
     * 下界
     */
    int lower;
    /**
     * 上界
     */
    int upper;
}
