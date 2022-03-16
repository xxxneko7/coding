package com.sol.algorithm.solution.tree;

import java.util.Random;

/**
 * 1206. 设计跳表
 */
class Skiplist {

    public Skiplist() {

    }

    public boolean search(int target) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < target) {
                p = p.forwards[i];
            }
        }

        return p.forwards[0] != null && p.forwards[0].data == target;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;
    }

    public boolean erase(int num) {
        return false;
    }

    int randomLevel() {
        int res = 1;
        Random random = new Random();
        while ((random.nextInt(MAX_LEVEL) & 1) == 1) res++;
        return res;
    }

    int MAX_LEVEL;
    int levelCount;
    Node head;

    public class Node {
        private int data = -1;
        private int count = 0;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}