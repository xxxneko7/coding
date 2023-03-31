package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N437 {
    public static void main(String[] args) {
    }

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        prefixToCount.put(0L, 1);
        return dfs(root, 0L);
    }

    Map<Long, Integer> prefixToCount = new HashMap<>();
    int targetSum;

    private int dfs(TreeNode root, long prefix) {
        if (root == null) return 0;
        prefix += root.val;

        int ret = prefixToCount.getOrDefault(prefix - targetSum, 0);

        prefixToCount.put(prefix, prefixToCount.getOrDefault(prefix, 0) + 1);
        ret += dfs(root.left, prefix);
        ret += dfs(root.right, prefix);
        // 状态恢复：在遍历完一个节点的所有子节点后，将其从 prefixToCount 中除去
        prefixToCount.put(prefix, prefixToCount.getOrDefault(prefix, 0) - 1);
        return ret;
    }
}
