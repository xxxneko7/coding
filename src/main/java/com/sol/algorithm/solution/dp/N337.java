package com.sol.algorithm.solution.dp;

import com.sol.algorithm.structure.TreeNode;

public class N337 {
    public int rob(TreeNode root) {
        int[] money = dfs(root);
        return Math.max(money[0], money[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] money = new int[]{0, 0};
        if (root == null) return money;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        money[0] = left[1] + right[1] + root.val;
        money[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return money;
    }
}
