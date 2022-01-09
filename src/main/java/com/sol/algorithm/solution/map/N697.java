package com.sol.algorithm.solution.map;


import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class N697 {
    public static void main(String[] args) {
        System.out.println(new N697().findShortestSubArray(new int[]{1}));
    }

    /**
     * n为【nums】的长度 <br>
     * - 时间复杂度：O(n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param nums 非空且只包含非负数的整数数组
     * @return 与 nums 度相同的 最短连续子数组 的长度
     */
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        // 某个数到其子数组对象的映射，用来统计数出现的频数和子数组的长度
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
        // 找到数组的度，及其对应最短子数组的长度
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

    /**
     * 以数组中某个数开始和结束的子数组
     */
    private class SubArray {
        /**
         * 数出现的频数
         */
        int freq;
        /**
         * 子数组的起始下标
         */
        int firstIdx;
        /**
         * 子数组的长度
         */
        int len;

        public SubArray(int firstIdx) {
            this.firstIdx = firstIdx;
            this.freq = 1;
            this.len = 1;
        }

        @Override
        public String toString() {
            return "SubArray{" +
                    "freq=" + freq +
                    ", firstIdx=" + firstIdx +
                    ", len=" + len +
                    '}';
        }
    }
}
