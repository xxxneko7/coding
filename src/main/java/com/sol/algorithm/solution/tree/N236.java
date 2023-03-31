package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;

public class N236 {

    private TreeNode ancestor = null;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        boolean find2 = lson && rson;
        boolean find1 = (root.val == p.val || root.val == q.val) && (lson || rson);
        if (find2 || find1) {
            ancestor = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ancestor;
    }
}
