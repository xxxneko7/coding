package com.sol.algorithm.solution.dp;

/**
 * 673. 最长递增子序列的个数
 */
public class N673 {
    /**
     * 时间复杂度：O() <br>
     * 空间复杂度：O() <br>
     *
     * @param nums 无序数组
     * @return 最长递增子序列的个数
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 2;
        while (l < n - 1) {
            if (nums[l] < nums[l - 1]) l++;
        }
        while(l<r){
            if(nums[r]>)
        }
    }
}
