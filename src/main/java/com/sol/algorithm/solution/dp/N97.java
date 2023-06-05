package com.sol.algorithm.solution.dp;

/**
 * <a href = "https://leetcode.cn/problems/interleaving-string/">97. 交错字符串</a>
 */
public class N97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                int p = i + j - 1;
                if (i > 0 && s3.charAt(p) == s1.charAt(i - 1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (j > 0 && s3.charAt(p) == s2.charAt(j - 1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[n1][n2];
    }
}
