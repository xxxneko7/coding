package com.sol.algorithm.solution.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class N873 {
    // 7 17 24 41 65
    // 11 4 7
    public static void main(String[] args) {
        System.out.println(new N873().lenLongestFibSubseq(new int[]{2, 5, 6, 7, 8, 10, 12, 17, 24, 41, 65}));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int longest = 0;
        Map<Integer, Integer> numToIndex = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            numToIndex.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = numToIndex.getOrDefault(arr[i] - arr[j], -1);
                if (k == -1) continue;
                dp[j][i] = Math.max(dp[k][j] + 1, 3);
                longest = Math.max(longest, dp[j][i]);
            }
        }
        return longest;
    }
}
