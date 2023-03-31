package com.sol.algorithm.util;

import com.sol.algorithm.structure.TreeNode;

import java.util.*;

public class TreeUtil {
    private static List<Integer> seq;

    public static List<Integer> inorder(TreeNode root) {
        seq = new ArrayList<>();
        dfs(root);
        return seq;
    }

    private static void dfs(TreeNode root) {
        if (Objects.isNull(root)) return;
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    }

    public static TreeNode create(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        for (int i = 1; i < nums.length; i += 2) {
            if (queue.isEmpty()) break;
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            cur.left = nums[i] == null ? null : new TreeNode(nums[i]);
            if (i + 1 == nums.length) break;
            cur.right = nums[i + 1] == null ? null : new TreeNode(nums[i + 1]);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }

    public static TreeNode find(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        TreeNode res;
        res = find(root.left, target);
        if (res == null) return find(root.right, target);
        else return res;
    }
}
