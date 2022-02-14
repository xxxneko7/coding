package com.sol.algorithm.solution.dp;

/**
 * 55. 跳跃游戏
 */
public class N55 {

    public static void main(String[] args) {
        System.out.println(new Greedy().canJump(new int[]{3, 2, 1, 0, 3}));
    }

    interface Solution {
        /**
         * 从数组第一个位置出发，是否能跳跃到最后一个位置
         *
         * @param nums 位置 i 所能跳跃的最大距离
         * @return 是否能到达最后一个位置
         */
        boolean canJump(int[] nums);
    }

    static class DP implements Solution {

        /**
         * 时间复杂度：O(n^2) <br>
         * 空间复杂度：O(n) <br>
         */
        @Override
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] f = new boolean[n];
            f[0] = true;
            for (int i = 0; i < n - 1; i++) {
                if (f[i]) {
                    for (int j = i; j <= Math.min(i + nums[i], n - 1); j++)
                        f[j] = true;
                }
            }
            return f[n - 1];
        }
    }

    static class Greedy implements Solution {

        /**
         * 时间复杂度：O(n) <br>
         * 空间复杂度：O(1) <br>
         */
        @Override
        public boolean canJump(int[] nums) {
            // furthest: 第 step+1 步所能到达的最远位置 | end: 第 step 步所能到达的最远位置
            int furthest = 0, end = 0;
            for (int i = 0; i < nums.length; i++) {
                furthest = Math.max(i + nums[i], furthest);
                if (i == end) {
                    end = furthest;
                } else if (i > end) {
                    return false;
                }
            }
            return true;
        }
    }
}
