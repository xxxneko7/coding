package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        if (root == null) return res;
        this.target = targetSum;
        dfs(root, new ArrayList<>(1), 0);
        return res;
    }

    List<List<Integer>> res;
    int target;

    private void dfs(TreeNode root, List<Integer> path, int sum) {
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            res.add(path);
            return;
        }
        if (root.left != null) dfs(root.left, new ArrayList<>(path), sum);
        if (root.right != null) dfs(root.right, new ArrayList<>(path), sum);
    }
}
