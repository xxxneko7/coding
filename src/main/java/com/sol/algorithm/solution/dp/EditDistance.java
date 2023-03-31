package com.sol.algorithm.solution.dp;

public class EditDistance {
    public int editDistance(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                // dp[i - 1][j - 1] - 修改; dp[i - 1][j] - 增加; dp[i][j - 1]) - 删除
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n];
    }
}
