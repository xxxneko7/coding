package com.sol.algorithm.solution.tree;

import java.util.*;

/**
 * 1206. 设计跳表
 */
class Skiplist {

    public Skiplist() {
        list = new ArrayList<>();
        list.add(new LinkedList<>());
    }

    public boolean search(int target) {

        return false;
    }

    public void add(int num) {

    }

    public boolean erase(int num) {
        return false;
    }

    int find(int target) {
        for (int i = maxLevel; i >= 0; i--) {
            for (int val : list.get(i)) {
                if (val == target) return val;
            }
        }
        return target;
    }

    int dial() {
        int res = 1;
        Random random = new Random();
        while ((random.nextInt(maxLevel + 1) & 1) == 1) res++;
        return res;
    }

    int maxLevel;
    List<LinkedList<Integer>> list;

    class Element {
        int idx;
        int val;
    }
}