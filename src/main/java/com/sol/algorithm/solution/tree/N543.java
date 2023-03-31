package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

public class N543 {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter - 1;
    }

    int diameter = 0;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
