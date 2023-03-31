package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

public class N230 {
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return val;
    }

    int k;
    int val;

    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        if (dfs(root.left)) return true;
        if (--k > 0) return dfs(root.right);
        val = root.val;
        return true;
    }
}
