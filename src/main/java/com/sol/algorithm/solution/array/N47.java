package com.sol.algorithm.solution.array;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class N47 {

    public static void main(String[] args) {
        System.out.println(new N47().permuteUnique(new int[]{2, 1, 1}));
    }


    /**
     * 全排列的结果集合
     */
    private List<List<Integer>> res;

    /**
     * 可包含重复数字的序列
     */
    private int[] nums;

    /**
     * 序列 {@code nums} 的长度
     */
    private int len;

    /**
     * 记录 {@code dfs} 过程中 {@code nums} 的数是否已访问
     */
    private boolean[] visited;

    /**
     * n为【nums】数组的长度 <br>
     * - 时间复杂度：O(n*n!) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param nums 可包含重复数字的序列
     * @return 按任意顺序 返回所有不重复的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        this.res = new ArrayList<>();
        this.visited = new boolean[this.len];
        // 排序以保证重复的数字连续
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(this.len));
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
        for (int i = 0; i < len; i++) {
            // 遇到重复的数字时，需要判断是否和前一个数字在同一深度
            // visited[i-1] 为【false】说明前一个数字已处理结束，其访问状态已恢复，此时需要跳过该重复的数字
            boolean repeatNumAtSameDepth = i > 0 && nums[i] == nums[i - 1] && !visited[i - 1];
            if (visited[i] || repeatNumAtSameDepth) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(depth + 1, path);
            // 状态恢复
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
