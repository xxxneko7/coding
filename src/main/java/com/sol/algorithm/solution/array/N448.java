package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.List;

public class N448 {
    public static void main(String[] args) {
        N448 solution = new N448();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] = nums[(nums[i] - 1) % nums.length] + nums.length;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) res.add(i + 1);
        }
        return res;
    }
}
