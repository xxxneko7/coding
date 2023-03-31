package com.sol.algorithm.solution.dp;

import com.sol.algorithm.util.TreeUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 516. 最长回文子序列
 */
public class PalindromeSubseq {
    public static void main(String[] args) {
        Solution solution = new DP();
        System.out.println(solution.longestPalindromeSubseq("abc"));
    }

    interface Solution {
        /**
         * 最长回文子序列的长度
         * <p>
         * n 为字符串 s 的长度 <br>
         * 时间复杂度：O(n^2) <br>
         * 空间复杂度：O(n^2) <br>
         *
         * @param s 字符串
         * @return 最长回文子序列的长度
         */
        int longestPalindromeSubseq(String s);
    }

    static class DP implements Solution {
        @Override
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

    static class Manacher implements Solution {
        @Override
        public int longestPalindromeSubseq(String s) {
            StringBuilder manacher = new StringBuilder("$#");
            for (char c : s.toCharArray()) {
                manacher.append(c).append("#");
            }
            manacher.append("!");
            int len = manacher.length();
            int[] f = new int[len];
            int iMax = 0, rMax = 0, lenOfLongest = 0;
            for (int i = 1; i < len; i++) {
                // j = 2 * iMax - i 表示以 iMax 为中心 i 对称的位置
                f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
                while (manacher.charAt(i + f[i]) == manacher.charAt(i - f[i])) f[i]++;
                if (i + f[i] - 1 > rMax) {
                    iMax = i;
                    rMax = i + f[i] - 1;
                }
                lenOfLongest = f[i] - 1;
            }
            return lenOfLongest;
        }
    }

}