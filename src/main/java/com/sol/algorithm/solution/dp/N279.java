package com.sol.algorithm.solution.dp;

/**
 * 279. 完全平方数
 */
public class N279 {
    public static void main(String[] args) {
        System.out.println(new N279().numSquares(12));
    }

    /**
     * 和为 n 的完全平方数的最小个数
     * <p>
     * 时间复杂度：O(nlog(n)) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param n 目标
     * @return 最小个数
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = 10000000;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}
