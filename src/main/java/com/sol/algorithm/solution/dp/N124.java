package com.sol.algorithm.solution.dp;

import com.sol.algorithm.structure.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class N124 {
    /**
     * 返回二叉树的最大路径和 <br>
     * - 路径：树中任意结点到其任意子结点的序列 <br>
     * - 路径和：路径中各结点的和 <br>
     * <p>
     * n 为二叉树结点的个数 <br>
     * 时间复杂度：O(n) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param root 二叉树根结点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        dfs(root, 0);
        return maxPathSum;
    }

    /**
     * @param cur     当前结点
     * @param preDown 自上而下 包含上一结点的最大路径
     * @return 自下而上 包含上一结点的最大路径
     */
    private int dfs(TreeNode cur, int preDown) {
        if (cur == null) return 0;
        preDown = Math.max(preDown + cur.val, cur.val);
        int preLeftUp = dfs(cur.left, preDown);
        int preRightUp = dfs(cur.right, preDown);
        maxPathSum = Math.max(maxPathSum, Math.max(preDown, preLeftUp + preRightUp + cur.val));
        return Math.max(Math.max(preLeftUp, preRightUp) + cur.val, cur.val);
    }

    /**
     * 最大路径和
     */
    int maxPathSum;
}
