package com.sol.algorithm.solution.stack;

import java.util.ArrayList;
import java.util.List;

public class N456 {
    public static void main(String[] args) {
        N456 solution = new N456();
        System.out.println(solution.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        List<Integer> candidate1 = new ArrayList<>(n);
        List<Integer> candidate2 = new ArrayList<>(n);
        candidate1.add(nums[0]);
        candidate2.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int iOfNum1 = biSearchFirst(candidate1, nums[i]);
            int iOfNum2 = biSearchLast(candidate2, nums[i]);
            if (iOfNum1 >= 0 && iOfNum2 >= 0 && iOfNum1 <= iOfNum2) return true;
            if (nums[i] < candidate1.get(candidate1.size() - 1)) {
                candidate1.add(nums[i]);
                candidate2.add(nums[i]);
            } else if (nums[i] > candidate2.get(candidate2.size() - 1)) {
                int min = candidate1.get(candidate1.size() - 1);
                while (!candidate2.isEmpty() && candidate2.get(candidate2.size() - 1) < nums[i]) {
                    candidate1.remove(candidate1.size() - 1);
                    candidate2.remove(candidate2.size() - 1);
                }
                candidate1.add(min);
                candidate2.add(nums[i]);
            }
        }
        return false;
    }

    private int biSearchFirst(List<Integer> candidate, int target) {
        int l = 0, r = candidate.size() - 1;
        if (candidate.get(r) >= target) return -1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (candidate.get(m) < target) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int biSearchLast(List<Integer> candidate, int target) {
        int l = 0, r = candidate.size() - 1;
        if (candidate.get(l) <= target) return -1;
        while (l < r) {
            int m = (l + r + 1) >> 1;
            if (candidate.get(m) > target) l = m;
            else r = m - 1;
        }
        return l;
    }
}
