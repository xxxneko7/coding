package com.sol.algorithm.solution.dp;

public class N309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        // 累计最大收益
        // pHoldOne - 持有一支股票; pInFreezing - 不持有股票，且处于冷冻期; pFree - 不持有股票，且不处于冷冻期
        int pHoldOne = -prices[0], pInFreezing = 0, pFree = 0;
        for (int i = 1; i < n; i++) {
            int pHoldOneToday = Math.max(pHoldOne, pFree - prices[i]);
            int pInFreezingToday = pHoldOne + prices[i];
            int pFreeToday = Math.max(pFree, pInFreezing);
            pHoldOne = pHoldOneToday;
            pInFreezing = pInFreezingToday;
            pFree = pFreeToday;
        }
        return Math.max(pInFreezing, pFree);
    }
}
