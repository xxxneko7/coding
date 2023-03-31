package com.sol.algorithm.solution.dp;

public class LCS {

    /**
     * 最长公共子序列
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return LCS
     */
    public String LCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m == 0 || n == 0) return "";
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j]) i--;
            else if (dp[i][j] == dp[i][j - 1]) j--;
            else {
                i--;
                j--;
                lcs.insert(0, s1.charAt(i));
            }
        }

        return lcs.toString();
    }
}
