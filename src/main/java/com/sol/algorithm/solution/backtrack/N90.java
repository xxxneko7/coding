package com.sol.algorithm.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1. 排序
 * 2. 搜索+回溯
 */
public class N90 {

    private List<List<Integer>> res;

    /**
     * Input: [1, 2, 2]
     * Output:
     * [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
     */
    public static void main(String[] args) {
        N90 solution = new N90();
        List<List<Integer>> res = solution.subsetsWithDup(new int[]{1, 2, 2});

        for (List<Integer> ans : res) {
            System.out.println(ans);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        res.add(Collections.emptyList());

        dfs(new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<Integer> ans, int[] nums, int k) {
        for (int i = k, pre = -11; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            pre = nums[i];
            ans.add(nums[i]);
            res.add(new ArrayList<>(ans));
            dfs(ans, nums, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
