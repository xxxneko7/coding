package com.sol.algorithm.solution.array;

import java.util.*;

/**
 * 46. 全排列
 */
public class N46 {

    public static void main(String[] args) {
        System.out.println(new N46().permute(new int[]{1, 2, 3}));
    }

    /**
     * 全排列的结果集合
     */
    private List<List<Integer>> res;

    /**
     * 序列 {@code nums} 的长度
     */
    private int len;

    /**
     * @param nums 不含重复数字的序列
     * @return 所有可能的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        res = new ArrayList<>();
        // 遍历 nums 作为初始路径
        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        dfs(0, path);
        return res;
    }

    /**
     * 深度优先遍历 从根节点到叶子节点的所有路径，将其加入结果集 {@code res}
     *
     * @param depth 当前深度
     * @param path  某条从根节点到叶子节点的路径
     */
    private void dfs(int depth, List<Integer> path) {
        // 到达叶子节点，将路径加入结果集
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 优先处理初始路径
        dfs(depth + 1, path);
        // 回溯，替换初始路径上当前深度的节点，得到其他可能的路径
        for (int i = depth + 1; i < len; i++) {
            Collections.swap(path, depth, i);
            dfs(depth + 1, path);
            // 状态恢复
            Collections.swap(path, depth, i);
        }
    }
}
