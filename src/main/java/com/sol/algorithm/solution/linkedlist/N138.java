package com.sol.algorithm.solution.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        Node original = head;
        int i = 0;
        while (original != null) {
            nodeToIndex.put(original, i++);
            nodes.add(new Node(original.val));
            original = original.next;
        }
        original = head;
        for (int j = 0; j < i - 1; j++) {
            Node cur = nodes.get(j);
            cur.random = getRandom(nodeToIndex, nodes, original);
            cur.next = nodes.get(j + 1);
            original = original.next;
        }

        nodes.get(i - 1).random = getRandom(nodeToIndex, nodes, original);
        return nodes.get(0);
    }

    private static Node getRandom(Map<Node, Integer> nodeToIndex, List<Node> nodes, Node original) {
        return original.random == null ? null : nodes.get(nodeToIndex.get(original.random));
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
