package com.sol.algorithm.solution.array;

import java.util.Arrays;

public class N283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new N283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (; k < nums.length; k++) {
            if (nums[k] == 0) break;
        }
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[k] = nums[i];
            nums[i] = 0;
            k++;
        }
    }
}
