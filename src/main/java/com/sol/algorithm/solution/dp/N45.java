package com.sol.algorithm.solution.dp;

/**
 * 45. 跳跃游戏II
 */
public class N45 {
    public static void main(String[] args) {
        System.out.println(new Greedy().jump(new int[]{1, 1, 1}));
    }

    interface Solution {
        /**
         * 从数组第一个位置出发，跳跃到最后一个位置所需要的最少步数
         *
         * @param nums 位置 i 所能跳跃的最大距离
         * @return 最少步数
         */
        int jump(int[] nums);
    }

    static class DP implements Solution {

        /**
         * 时间复杂度：O(n^2) <br>
         * 空间复杂度：O(n) <br>
         */
        @Override
        public int jump(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 1; i < n; i++) {
                f[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) f[i] = Math.min(f[i], f[j] + 1);
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
        public int jump(int[] nums) {
            // step：步数 | furthest: 第 step+1 步所能到达的最远位置 | end: 第 step 步所能到达的最远位置
            int steps = 0, furthest = 0, end = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                furthest = Math.max(i + nums[i], furthest);
                if (i == end) {
                    end = furthest;
                    steps++;
                }
            }
            return steps;
        }
    }
}
