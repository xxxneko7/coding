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
     * <pre>
     *             r             n
     *       + - - - - - - - - - +
     *     t | x x x x x x x x x |
     *       | - - - - - - - - - |
     *       |       |           |
     *       |       |           |
     *     b |       |           |
     *       | - - - - - - - - - |
     *       | x x x x x x x x x |
     *     m + - - - - - - - - - +
     * </pre>
     *
     * - 时间复杂度：O(m^2 * n) <br/>
     * - 空间复杂度：O(m) <br/>
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        for (int t = 0; t < m; t++) {
            int[] sumOfCol = new int[n];
            for (int b = t; b < m; b++) {
                for (int r = 0; r < n; r++) {
                    sumOfCol[r] += matrix[b][r];
                }
                count += subarraySum(sumOfCol, target);
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumToNum = new HashMap<>(nums.length);
        preSumToNum.put(0, 1);
        int count = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            count += preSumToNum.getOrDefault(preSum - k, 0);
            preSumToNum.put(preSum, preSumToNum.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
