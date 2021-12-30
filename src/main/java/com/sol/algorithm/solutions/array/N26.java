package com.sol.algorithm.solutions.array;


import com.sol.algorithm.beans.Solution;

public class N26 implements Solution {
    @Override
    public void solve() {
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
