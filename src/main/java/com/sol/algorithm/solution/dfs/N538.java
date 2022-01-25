package com.sol.algorithm.solution.dfs;

import com.sol.algorithm.structure.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class N538 {
    /**
     * 把二叉搜索树转换为累加树 <br>
     * 解题思路：按照【右子树 -> 根节点 -> 左子树】的顺序遍历 BST。并记录累加值
     * <p>
     * n 为 BST 节点个数 <br>
     * - 时间复杂度：O(n!) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param root BST 根节点
     * @return 累加树根节点
     */
    public TreeNode convertBST(TreeNode root) {
        return dfs(root);
    }

    /**
     * 深度优先搜素
     *
     * @param cur BST 当前节点
     * @return 累加树根节点
     */
    private TreeNode dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        // 累加树的根节点
        TreeNode root = new TreeNode();
        // 处理右子树
        root.right = dfs(cur.right);
        // 更新节点值
        sum += cur.val;
        root.val = sum;
        // 处理左子树
        root.left = dfs(cur.left);
        return root;
    }

    /**
     * 累加值
     */
    private int sum;
}
