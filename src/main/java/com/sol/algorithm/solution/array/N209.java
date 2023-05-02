package com.sol.algorithm.solution.array;

import java.util.Arrays;

public class N209 {
    public static void main(String[] args) {
        N209 solution = new N209();
        System.out.println(solution.minSubArrayLen(12, new int[]{1, 2, 3, 4, 5}));
    }

    /*public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == target) return 1;
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int minSubArrayLen = n + 1;
        for (int i = 1; i <= n; i++) {
            if (prefixSum[i] < target) continue;
            // 找到小于等于 k 的前缀和
            int k = prefixSum[i] - target;
            int l = 0, r = i - 1;
            while (l < r) {
                int m = (l + r + 1) >> 1;
                if (prefixSum[m] <= k) l = m;
                else r = m - 1;
            }
            minSubArrayLen = Math.min(minSubArrayLen, i - l);
        }
        return minSubArrayLen == n + 1 ? 0 : minSubArrayLen;
    }*/

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
