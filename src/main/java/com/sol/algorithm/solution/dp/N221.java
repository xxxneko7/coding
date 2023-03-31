package com.sol.algorithm.solution.dp;

public class N221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '0') continue;
            dp[i][0] = 1;
            maxLength = 1;
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == '0') continue;
            dp[0][i] = 1;
            maxLength = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength * maxLength;
    }
}
