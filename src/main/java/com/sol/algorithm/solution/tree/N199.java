package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;
import com.sol.algorithm.util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N199 {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.create(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println(new N199().rightSideView(root));
        ;
    }
    /*public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.peek().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return res;
    }*/

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList<>();
        this.depth = 0;
        dfs(root, 0);
        return res;
    }

    int depth;
    List<Integer> res;

    private void dfs(TreeNode root, int curDepth) {
        if (root == null) return;
        if (curDepth == depth) {
            res.add(root.val);
            depth++;
        }
        dfs(root.right, curDepth + 1);
        dfs(root.left, curDepth + 1);
    }
}
