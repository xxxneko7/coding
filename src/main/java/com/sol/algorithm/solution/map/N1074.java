package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 */
public class N1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int i, j, k;
        for (i = 1; i < m + 1; i++) {
            for (j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = 0, cur;
        for (i = 1; i < m + 1; i++) {
            for (k = 0; k < i; k++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (j = 1; j < n + 1; j++) {
                    cur = sum[i][j] - sum[k][j];
                    if (target == cur) {
                        res++;
                    }
                    if (map.containsKey(cur - target)) {
                        res += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
