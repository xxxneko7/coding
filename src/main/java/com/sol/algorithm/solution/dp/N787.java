package com.sol.algorithm.solution.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N787 {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 2, 2}, {3, 0, 4}, {1, 3, 5}, {3, 2, 7}};
        int src = 0, dst = 2, k = 2;
        N787 solution = new N787();
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[src] = 0;
        int res = INF;
        for (int i = 0; i <= k; i++) {
            int[] next = new int[n];
            Arrays.fill(next, INF);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                next[to] = Math.min(next[to], dp[from] + cost);
            }
            dp = next;
            res = Math.min(res, dp[dst]);
        }
        return res == INF ? -1 : res;
    }
}
