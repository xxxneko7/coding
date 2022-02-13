package com.sol.algorithm.solution.dp;

/**
 * 673. 最长递增子序列的个数
 */
public class N673 {
    /**
     * 时间复杂度：O(n!) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param nums 无序数组
     * @return 最长递增子序列的个数
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        Status[] dp = new Status[n];
        Status LIS = new Status(0, 0);
        for (int i = 0; i < n; i++) {
            dp[i] = new Status(1, 1);
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = dp[i].update(dp[j]);
            }
            LIS = LIS.compare(dp[i]);
        }
        return LIS.num;
    }

    class Status {
        /**
         * LIS 长度
         */
        int len;
        /**
         * LIS 个数
         */
        int num;

        Status(int maxLen, int num) {
            this.len = maxLen;
            this.num = num;
        }

        /**
         * 状态更新
         *
         * @param status 历史状态
         * @return 当前状态
         */
        public Status update(Status status) {
            int newLen = status.len + 1;
            if (len < newLen) {
                len = newLen;
                num = status.num;
            } else if (len == newLen) {
                num += status.num;
            }
            return this;
        }

        /**
         * 状态比较
         *
         * @param status 状态
         * @return LIS 状态
         */
        public Status compare(Status status) {
            if (len < status.len) return status;
            if (len == status.len) num += status.num;
            return this;
        }
    }
}
