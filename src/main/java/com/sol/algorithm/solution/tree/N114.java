package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

public class N114 {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        for (; cur != null; cur = cur.right) {
            if (cur.left == null) continue;
            TreeNode temp = cur.left;
            TreeNode predecessor = temp;
            while (predecessor.right != null) predecessor = predecessor.right;
            predecessor.right = cur.right;
            cur.right = temp;
            cur.left = null;
        }
    }
}
