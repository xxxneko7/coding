package com.sol.algorithm.solution.dfs;

import java.util.*;

/**
 * 18. 四数之和
 */
public class N18 {

    /**
     * 返回满足条件的不重复的四元组 <br>
     * - 0 <= a, b, c, d < n <br>
     * - a、b、c 和 d 互不相同 <br>
     * - nums[a] + nums[b] + nums[c] + nums[d] == target <br>
     *
     * @param nums   数组
     * @param target 目标
     * @return 和为 target 的4元组
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        this.n = nums.length;
        this.res = new ArrayList<>();
        this.path = new ArrayList<>(4);
        // 排序，便于去重和剪枝
        Arrays.sort(nums);
        dfs(0, 4, target);
        return res;
    }

    /**
     * 使用 {@code nums[i], i ∈ [idx, n-1]} 构造深度为 {@code d} 的路径
     *
     * @param idx 当前下标
     * @param d   剩余深度
     * @param t   目标值
     */
    public void dfs(int idx, int d, int t) {
        if (d == 0) {
            if (t == 0) res.add(new ArrayList<>(path));
            return;
        }
        // 短路径剪枝：可使用的数不足树深度时返回
        if (n - idx < d) {
            return;
        }
        // 最大值剪枝：最大值小于 目标和 时返回，最大值 = 最大的可使用数 * 剩余深度
        if (t > nums[n - 1] * d) {
            return;
        }
        // 最小值剪枝：最小值大于 目标和 时返回，最小值 = 最小的可使用数 * 剩余深度
        if (t < nums[idx] * d) {
            return;
        }
        for (int i = idx; i < n; i++) {
            // 去重
            if (i > idx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(i + 1, d - 1, t - nums[i]);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 输入数组
     */
    private int[] nums;
    /**
     * 数组长度
     */
    private int n;
    /**
     * 路径
     */
    private List<Integer> path;
    /**
     * 结果
     */
    private List<List<Integer>> res;
}
