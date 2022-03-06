package com.sol.algorithm.solution.string;

/**
 * 44. 通配符匹配
 */
public class N44 {
    public static void main(String[] args) {
        System.out.println(new N44().isMatch("adceb", "*a*b"));
    }

    /**
     * '?' 可以匹配任何单个字符 <br>
     * '*' 可以匹配任意字符串（包括空字符串） <br>
     * <p>
     * n、m 分别为 strs 的长度 和 strs 中字符串的平均长度
     * <li> 时间复杂度：O(n * m) </li>
     * <li> 空间复杂度：O(n * m) </li>
     *
     * @param s 字符串
     * @param p 模式串
     * @return p 是否匹配 s
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i) == '*') dp[0][i] = true;
            else break;
        }

        for (int i = 1; i <= n; i++) {
            char chOfS = s.charAt(i);
            for (int j = 1; j <= m; j++) {
                char chOfP = p.charAt(j);
                if (chOfP == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (chOfP == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j - 1] && chOfS == chOfP;
            }
        }

        return dp[n][m];
    }
}
