package com.sol.algorithm.solution.dp;

/**
 * 673. 最长递增子序列的个数
 */
public class N673 {
    /**
     * n 为数组长度 <br>
     * 时间复杂度：O(n^2) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param nums 无序数组
     * @return 最长递增子序列的个数
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        State[] dp = new State[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new State(1, 1);
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = dp[i].transfer(dp[j]);
            }
        }
        State LIS = new State(0, 0);
        for (int i = 0; i < n; i++) {
            LIS = LIS.update(dp[i]);
        }
        return LIS.num;
    }

    class State {
        /**
         * LIS 长度
         */
        int len;
        /**
         * LIS 个数
         */
        int num;

        State(int maxLen, int num) {
            this.len = maxLen;
            this.num = num;
        }

        /**
         * 状态转移
         *
         * @param state 历史状态
         * @return 当前状态
         */
        public State transfer(State state) {
            int newLen = state.len + 1;
            if (len < newLen) {
                len = newLen;
                num = state.num;
            } else if (len == newLen) {
                num += state.num;
            }
            return this;
        }

        /**
         * LIS 状态更新
         *
         * @param state 状态
         * @return LIS 状态
         */
        public State update(State state) {
            if (len < state.len) return state;
            if (len == state.len) num += state.num;
            return this;
        }
    }
}
