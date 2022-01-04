package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class N560 {
    /**
     * n为【nums】的长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preAndToNum = new HashMap<>();
        int count = 0, preAnd = 0;
        for (int num : nums) {
            preAnd += num;
            count += preAndToNum.getOrDefault(preAnd - k, 0);
            preAndToNum.put(preAnd, preAndToNum.getOrDefault(preAnd, 0) + 1);
        }
        return count;
    }
}
