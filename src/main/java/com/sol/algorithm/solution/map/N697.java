package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class N697 {
    public static void main(String[] args) {
        System.out.println(new N697().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    private class SubArray {
        /**
         * 数出现的频数
         */
        int freq;
        /**
         * 数第一次出现的下标
         */
        int firstIdx;
        /**
         * 子数组的长度
         */
        int len;

        public SubArray(int firstIdx) {
            this.firstIdx = firstIdx;
            this.freq = 1;
        }
    }

    /**
     * n为【nums】的长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     */
    public int findShortestSubArray(int[] nums) {
        // 数到子数组对象的映射，用来统计数出现的频数和子数组的长度
        int n = nums.length;
        Map<Integer, SubArray> numToSubArray = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            SubArray subArray = numToSubArray.get(nums[i]);
            if (subArray == null) {
                numToSubArray.put(nums[i], new SubArray(i));
            } else {
                subArray.freq += 1;
                subArray.len = i - subArray.firstIdx + 1;
            }
        }
        // 找到数出现频数最大的度，及其对应最短子数组的长度
        int degree = 0, minLen = n;
        for (SubArray subArray : numToSubArray.values()) {
            if (degree < subArray.freq) {
                degree = subArray.freq;
                minLen = subArray.len;
            } else if (degree == subArray.freq) {
                minLen = Math.min(minLen, subArray.len);
            }
        }
        return minLen;
    }
}
