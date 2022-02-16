package com.sol.algorithm.solution.dp;

/**
 * 516. 最长回文子序列
 */
public class N516 {
    public static void main(String[] args) {
        System.out.println(new N516().longestPalindromeSubseq("bbbab"));
    }

    /**
     * 最长回文子序列的长度
     *
     * @param s 字符串
     * @return 最长回文子序列的长度
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // f[l][r] 为区间 [l, r] 内最长回文子序列的长度
        int[][] f = new int[n][n];
        for (int l = n - 1; l >= 0; l--) {
            f[l][l] = 1;
            for (int r = l + 1; r < n; r++) {
                if (s.charAt(l) == s.charAt(r)) f[l][r] = f[l + 1][r - 1] + 2;
                else f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);
            }
        }

        return f[0][n - 1];
    }
}
