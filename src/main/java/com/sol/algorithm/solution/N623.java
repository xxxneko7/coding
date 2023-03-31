package com.sol.algorithm.solution;

import com.sol.algorithm.structure.TreeNode;

import java.util.Objects;

public class N623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRowToNodeWithDepth(root, val, depth - 1);
        return root;
    }

    private void addRowToNodeWithDepth(TreeNode root, int val, int depth) {
        if (Objects.isNull(root)) {
            return;
        }
        if (depth == 1) {
            addRow(root, val);
            return;
        }
        addRowToNodeWithDepth(root.left, val, depth - 1);
        addRowToNodeWithDepth(root.right, val, depth - 1);
    }

    private void addRow(TreeNode node, int val) {
        TreeNode newLeftNode = new TreeNode(val);
        TreeNode newRightNode = new TreeNode(val);
        newLeftNode.left = node.left;
        newRightNode.right = node.right;
        node.left = newLeftNode;
        node.right = newRightNode;
    }
}
