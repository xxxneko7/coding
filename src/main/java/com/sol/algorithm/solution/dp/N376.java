package com.sol.algorithm.solution.dp;

public class N376 {
    /**
     * 【DP】
     * up[i] = up[i - 1], nums[i] <= nums[i - 1];
     * >     = max(up[i - 1], down[i - 1] + 1), nums[i] > nums[i - 1];
     * down[i] = down[i - 1], nums[i] >= nums[i - 1];
     * >       = max(down[i - 1], up[i - 1] + 1), nums[i] < nums[i - 1];
     * <p>
     * 【优化】
     * 1. up[], down[] -> up, down;
     * 2. up = max(up, down + 1) -> up = down + 1; // down 与 up 的绝对差值不大于 1
     * 3. 【峰】和【谷】交替出现时摆动序列长度最长; // 【贪心】
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int preDiff = nums[1] - nums[0];
        int res = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }
}
