package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

public class N617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        TreeNode root = new TreeNode();
        root.val = root1.val + root2.val;
        root.left = merge(root1.left, root2.left);
        root.right = merge(root1.right, root2.right);
        return root;
    }
}
