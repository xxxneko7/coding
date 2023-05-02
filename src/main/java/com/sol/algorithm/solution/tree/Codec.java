package com.sol.algorithm.solution.tree;

import com.sol.algorithm.structure.TreeNode;
import com.sol.algorithm.util.TreeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Codec {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.create(new Integer[]{41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30, 36, null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4, 29, 32, null, null, null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33, null, 6, 8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null, null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23});
        Codec codec = new Codec();
        String seq = codec.serialize(root);
        System.out.println(seq);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        seq = new StringBuilder();
        preOrder(root);
        seq.deleteCharAt(seq.length() - 1);
        return seq.toString();
    }

    StringBuilder seq;

    private void preOrder(TreeNode root) {
        if (root == null) return;
        seq.append(root.val).append(",");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        Queue<Integer> queue = Arrays.stream(data.split(",")).map(Integer::parseInt).collect(LinkedList::new, List::add, List::addAll);

        return construct(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty() || queue.peek() < lower || queue.peek() > upper) return null;
        int val = queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = construct(queue, lower, val);
        root.right = construct(queue, val, upper);
        return root;
    }
}