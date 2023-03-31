package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;
import com.sol.algorithm.util.TreeUtil;

public class N235 {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.create(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = TreeUtil.find(root, 2);
        TreeNode q = TreeUtil.find(root, 8);
        System.out.println(new N235().lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) return dfs(root, p.val, q.val);
        else return dfs(root, q.val, p.val);
    }

    private TreeNode dfs(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (p <= root.val && root.val <= q) return root;
        else if (q < root.val) return dfs(root.left, p, q);
        else return dfs(root.right, p, q);
    }
}
