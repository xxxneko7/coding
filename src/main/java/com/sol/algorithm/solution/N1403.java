package com.sol.algorithm.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int sumOfSubNums = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            sum = sum - num;
            sumOfSubNums += num;
            res.add(num);
            if (sumOfSubNums > sum) {
                return res;
            }
        }
        return res;
    }
}
