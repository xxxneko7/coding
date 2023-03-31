package com.sol.algorithm.solution.hash;

import com.sol.algorithm.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class N653 {
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        this.values = new HashSet<>();
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        int val = root.val;
        if (!values.contains(val)) values.add(root.val);
        if (values.contains(k - val)) return true;
        dfs(root.left);
        dfs(root.right);
        return false;
    }

    Set<Integer> values;
    int k;
}
