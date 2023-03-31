package com.sol.algorithm.solution.dp;

public class N152 {
    public static void main(String[] args) {
        System.out.println(new N152().maxProduct(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct(int[] nums) {
        int max, min, ans;
        max = min = ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max, preMin = min;
            max = Math.max(preMax * nums[i], Math.max(nums[i], preMin * nums[i]));
            min = Math.min(preMin * nums[i], Math.min(nums[i], preMax * nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
