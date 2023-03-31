package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;
import com.sol.algorithm.util.TreeUtil;

/**
 * 3
 * 1   5
 * 0 2 4 6
 */
public class N98 {
    public static void main(String[] args) {
        Integer[] nums = {3, 1, 5, 0, 2, 4, 6};
        TreeNode root = TreeUtil.create(nums);
        System.out.println(new N98().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        isValid(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
        return isValidBST;
    }

    boolean isValidBST = true;

    private void isValid(TreeNode root, long min, long max) {
        if (!isValidBST) return;
        if (root == null) return;
        if (root.val <= min || root.val >= max)
            isValidBST = false;
        isValid(root.left, min, root.val);
        isValid(root.right, root.val, max);
    }
}
