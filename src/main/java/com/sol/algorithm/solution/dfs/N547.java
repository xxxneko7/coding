package com.sol.algorithm.solution.dfs;

/**
 * 547. 省份数量
 */
public class N547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        System.out.println(new N547().findCircleNum(isConnected));
    }

    /**
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市 <br>
     * isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连
     * <p>
     * n 为城市的数量 <br>
     * 时间复杂度：O(n^2) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param isConnected 连接矩阵
     * @return 省份的数量
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) unionSet(i, j);
            }
        }
        int numOfProvinces = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) numOfProvinces++;
        }
        return numOfProvinces;
    }

    /**
     * 查找元素 x 所在集合的代表元素
     *
     * @param x 元素
     * @return 代表元素
     */
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    /**
     * 合并集合
     *
     * @param x 元素
     * @param y 元素
     */
    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[x] = y;
    }

    /**
     * parent[i] 为结点 i 的父结点
     */
    private int[] parent;
}
