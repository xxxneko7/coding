package com.sol.algorithm.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 310. 最小高度树
 */
public class N310 {
    public static void main(String[] args) {
        int n;
        int[][] edges;
        n = 4;
        edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        // [1]
        System.out.println(new N310().findMinHeightTrees(n, edges));
        n = 6;
        edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        // [3,4]
        System.out.println(new N310().findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();
        return ans;
    }
}