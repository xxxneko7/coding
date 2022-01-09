package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class N560 {
    /**
     * n为【nums】的长度 <br>
     * - 时间复杂度：O(n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param nums 数组
     * @param k 目标值
     * @return 元素和等于目标值的非空子数组的数量
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumToNum = new HashMap<>();
        preSumToNum.put(0, 1);
        int count = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            count += preSumToNum.getOrDefault(preSum - k, 0);
            preSumToNum.put(preSum, preSumToNum.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
