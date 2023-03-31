package com.sol.algorithm.solution.dp;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(new LIS().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int len = 1;
        int[] d = new int[n + 1];
        d[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (d[len] < nums[i]) {
                len++;
                d[len] = nums[i];
                continue;
            }
            int l = 1, r = len;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (d[mid] >= nums[i]) r = mid;
                else l = mid + 1;
            }
            d[l] = nums[i];
        }
        return len;
    }
}
