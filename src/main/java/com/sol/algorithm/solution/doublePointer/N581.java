package com.sol.algorithm.solution.doublePointer;

public class N581 {
    public static void main(String[] args) {
        N581 solution = new N581();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, r = -1;
        int min = Integer.MAX_VALUE, l = -1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (max > nums[i]) r = i;
            else max = nums[i];
            if (min < nums[j]) l = j;
            else min = nums[j];
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
