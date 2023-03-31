package com.sol.algorithm.solution.dp;

import com.sol.algorithm.structure.TreeNode;

public class N121 {
    public void flatten(TreeNode root) {
        flattenAndBackTail(root);
    }

    public TreeNode flattenAndBackTail(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        if (root.left == null) return flattenAndBackTail(root.right);
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flattenAndBackTail(root.right);
        }
        TreeNode tail = flattenAndBackTail(root.left);
        tail.right = root.right;
        root.right = root.left;
        return flattenAndBackTail(tail.right);
    }
}
