package com.sol.algorithm.solution.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 找出所有方案，考虑 搜索+回溯，通过 动态规划 优化判断
 */
public class N131 {
    /**
     * Input: aab
     * Output: [[a,a,b],[aa,b]]
     */
    public static void main(String[] args) {
        N131 solution = new N131();
        List<List<String>> res = solution.partition("aab");
        for (List<String> ans : res) {
            System.out.println(ans);
        }
    }

    List<List<String>> partition(String s) {
        this.n = s.length();
        this.res = new ArrayList<>();
        this.ans = new ArrayList<>();
        this.dp = new boolean[n][n];

        // 构造动态规划函数
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (!dp[i][j]) continue;
            ans.add(s.substring(i, j + 1));
            dfs(s, j + 1);
            ans.remove(ans.size() - 1);
        }
    }

    List<List<String>> res;
    List<String> ans;
    boolean[][] dp;
    int n;
}
