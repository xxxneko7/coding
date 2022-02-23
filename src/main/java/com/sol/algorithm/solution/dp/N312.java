package com.sol.algorithm.solution.dp;

/**
 * 312. 戳气球
 */
public class N312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        nums1 = new int[n + 2];
        System.arraycopy(nums, 0, nums1, 1, n);
        nums1[0] = 1;
        nums1[n + 1] = 1;

        f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                f[i][j] = -1;

        return calc(1, n);
    }

    private int calc(int l, int r) {
        if (l > r) return 0;
        if (f[l][r] != -1) return f[l][r];

        for (int p = l; p <= r; p++) {
            f[l][r] = Math.max(f[l][r], calc(l, p - 1) + calc(p + 1, r) + nums1[l - 1] * nums1[p] * nums1[r + 1]);
        }
        return f[l][r];
    }

    private int[] nums1;
    private int[][] f;
}
