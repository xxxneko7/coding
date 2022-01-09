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
     * 解题思路基于 LeetCode 560. 和为 K 的子数组 <br>
     *
     * <p>
     * m、n分别为【matrix】的行、列数 <br>
     * - 时间复杂度：O(m^2 * n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return 元素总和等于目标值的非空子矩阵的数量
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        // 遍历上界t
        for (int t = 0; t < m; t++) {
            int[] sumsOfCols = new int[n];
            // 遍历下界b
            for (int b = t; b < m; b++) {
                for (int r = 0; r < n; r++) {
                    // 计算上下界中每一列的元素和
                    sumsOfCols[r] += matrix[b][r];
                }
                count += subarraySum(sumsOfCols, target);
            }
        }
        return count;
    }

    /**
     * @param nums 数组
     * @param t    目标值
     * @return 元素和等于目标值的非空子数组的数量
     */
    public int subarraySum(int[] nums, int t) {
        Map<Integer, Integer> preSumToNum = new HashMap<>(nums.length);
        preSumToNum.put(0, 1);
        int count = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            count += preSumToNum.getOrDefault(preSum - t, 0);
            preSumToNum.put(preSum, preSumToNum.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
