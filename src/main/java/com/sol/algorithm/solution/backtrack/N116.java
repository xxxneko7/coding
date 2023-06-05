package com.sol.algorithm.solution.backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class N116 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            Node prev = nodes.poll();
            addChildren(nodes, prev);
            for (int i = 1; i < size; i++) {
                prev.next = nodes.poll();
                prev = prev.next;
                addChildren(nodes, prev);
            }
            prev.next = null;
        }
        return root;
    }

    private static void addChildren(Queue<Node> nodes, Node prev) {
        if (prev.left != null) nodes.offer(prev.left);
        if (prev.right != null) nodes.offer(prev.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
