package com.sol.algorithm.solution.dfs;

import java.util.*;

/**
 * 684. 冗余连接
 */
public class N684 {
    public static void main(String[] args) {
        // [4, 10]
        int[][] edges = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        System.out.println(Arrays.toString(new N684().findRedundantConnection(edges)));
    }

    /**
     * 找到一条可以删除的边，使得剩余部分是一个结点数为 n 的树。如果有多个答案，返回数组 edges 中最后出现的边
     * <p>
     * n 结点的个数 n = edges.length <br>
     * 时间复杂度：O(n!) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param edges 边
     * @return 冗余边
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (!unionSet(edge[0], edge[1])) return edge;
        }
        return null;
    }

    /**
     * 查找元素 x 所在集合的代表元素
     *
     * @param x 元素
     * @return 代表元素
     */
    private int find(int x) {
        parent[x] = parent[x] == x ? x : find(parent[x]);
        return parent[x];
    }

    /**
     * 合并集合
     *
     * @param x 元素
     * @param y 元素
     * @return 是否可以合并
     */
    private boolean unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[x] = y;
        return true;
    }

    /**
     * parent[i] 为结点 i 的父结点
     */
    int[] parent;
}
