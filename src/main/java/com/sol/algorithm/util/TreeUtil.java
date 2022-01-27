package com.sol.algorithm.util;

import com.sol.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeUtil {
    private List<Integer> seq;

    public List<Integer> inorder(TreeNode root) {
        seq = new ArrayList<>();
        dfs(root);
        return seq;
    }

    private void dfs(TreeNode root) {
        if (Objects.isNull(root)) return;
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    }
}
