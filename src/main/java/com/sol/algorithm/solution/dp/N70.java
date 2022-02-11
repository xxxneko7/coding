package com.sol.algorithm.solution.dp;

/**
 * 70. 爬楼梯
 */
public class N70 {

    /**
     * 每次能爬 1 或 2 层楼，返回爬到第 n 层的方案个数
     * <p>
     * 时间复杂度：O(n) <br>
     * 空间复杂度：O(1) <br>
     *
     * @param n 楼梯的层数
     * @return 方案数
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int i = 1, j = 2, t = 0;
        for (; 3 <= n; n--) {
            t = i + j;
            i = j;
            j = t;
        }
        return t;
    }
}
