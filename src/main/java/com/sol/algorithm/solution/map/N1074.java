package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 */
public class N1074 {
    public static void main(String[] args) {
        int[][] matrix = {{1, -1}, {-1, 1}};
        int target = 0;
        System.out.println(new N1074().numSubmatrixSumTarget(matrix, target));
    }

    /**
     * m、n分别为【matrix】的行、列数 <br/>
     * 定义矩阵元素和 {@code S(m - 1, n - 1) = Sum(matrix[row][col], 其中 row ∈ [0, m - 1], col ∈ [0, n - 1])}
     * <p>
     * 解题思路：<br>
     * 1. 考虑 子矩阵A，其元素和为：
     * <pre> {@code S_A = S(b, r) = Sum(matrix[row][col]), row ∈ [0, b], col ∈ [0, r]}
     *
     *                     r     n
     *       + - - - - - - - - - +
     *       |               | x |
     *       |               | x |
     *       |       A       | x |
     *       |               | x |
     *     b |               | x |
     *       | - - - - - - - + x |
     *       | x x x x x x x x x |
     *     m + - - - - - - - - - +
     * </pre>
     * <p>
     * 2. 遍历 {@code l} 以确定 子矩阵B 的元素和 {@code S_B = S(b, l), l ∈ [0, r)} <br>
     * <p>
     * 3. 调整 {@code t} 以确定 子矩阵C 的元素和
     * <pre> {@code S_C = S(t, r) - S(t, l), t ∈ [0, b)}
     *
     *             l       r     n
     *       + - - - - - - - - - +
     *     t |       |   C   | x |
     *       |       | - - - | x |
     *       |   B   |       | x |
     *       |       |   K   | x |
     *     b |       |       | x |
     *       | - - - - - - - + x |
     *       | x x x x x x x x x |
     *     m + - - - - - - - - - +
     * </pre>
     * <p>
     * 4. 则 任意子矩阵K 的元素和为 {@code S_K = (S_A - S_B) - S_C}
     * <p>
     * 实现思路：<br>
     * 1. 通过循环确定 {@code b 和 r} <br>
     * 2. 利用【前缀和】优化元素和 {@code S} 的计算 <br>
     * 3. 利用【哈希表】优化 {@code S_K = target} 的计数 <br>
     * <p>
     * - 时间复杂度：O(m * n) <br/>
     * - 空间复杂度：O(m + n) <br/>
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        // preSums[0] = 0,
        // preSums[r] = Sum(matrix[row][col]), 其中 row ∈ [0, b], col ∈ [0, r]
        int[] preSums = new int[n + 1];
        Map<String, Integer> preSumToNum = new HashMap<>(m * n);
        for (int b = 0; b < m; b++) {
            // preSum = Sum(matrix[row][col]), 其中 row = b, col ∈ [0, r]
            int preSum = 0;
            for (int r = 1; r <= n; r++) {
                preSum += matrix[b][r - 1];
                preSums[r] += preSum;
                int sum = preSums[r];
                for (int l = 0; l < r; l++) {
                    int expectSum = sum - preSums[l];
                    count += preSumToNum.getOrDefault(getKey(l, r, expectSum - target), expectSum == target? 1 : 0);
                    preSumToNum.put(getKey(l, r, expectSum), preSumToNum.getOrDefault(getKey(l, r, expectSum), expectSum == target? 1 : 0) + 1);
                }
            }
        }
        System.out.println(preSumToNum);
        return count;
    }

    private String getKey(int l, int r, int sum) {
        return String.format("(%d, %d]#%d", l, r, sum);
    }
}
