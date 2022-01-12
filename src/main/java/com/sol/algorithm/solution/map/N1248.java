package com.sol.algorithm.solution.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 */
public class N1248 {

    /**
     * n为【nums】的长度 <br>
     * - 时间复杂度：O(n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param nums 整数数组
     * @param k    整数
     * @return 优美子数组的个数 - 「优美子数组」为恰好有 k 个奇数的连续子数组
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> preSumToNum = new HashMap<>(n + 1, 1);
        preSumToNum.put(0, 1);
        int count = 0, preSum = 0;
        for (int num : nums) {
            // 子数组中奇数的个数，等于 子数组中的数模2（或按位与1） 再求和
            preSum += (num & 1);
            count += preSumToNum.getOrDefault(preSum - k, 0);
            preSumToNum.put(preSum, preSumToNum.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
