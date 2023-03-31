package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;
import com.sol.algorithm.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class N94 {
    public static void main(String[] args) {
        Integer[] nums = {5, 1, 4, null, null, 3, 6};
        TreeNode root = TreeUtil.create(nums);
        System.out.println(new N94().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private List<Integer> res;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
