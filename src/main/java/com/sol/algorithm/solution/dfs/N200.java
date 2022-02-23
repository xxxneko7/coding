package com.sol.algorithm.solution.dfs;

/**
 * 200. 岛屿数量
 */
public class N200 {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '0', '1'},
            {'1', '1', '1'},
            {'1', '0', '1'},
        };
        System.out.println(new DisjointSet().numIslands(grid));
    }

    interface Solution {
        /**
         * @param grid 地图
         * @return 岛屿数量
         */
        int numIslands(char[][] grid);
    }

    static class DisjointSet implements Solution {

        /**
         * n、m 分别为 grid 的高和宽 <br>
         * 时间复杂度：O(nm) <br>
         * 空间复杂度：O(nm) <br>
         */
        @Override
        public int numIslands(char[][] grid) {
            this.n = grid.length;
            this.m = grid[0].length;
            int len = n * m;
            parent = new int[len];
            for (int i = 0; i < len; i++) parent[i] = i;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '0') {
                        parent[index(i, j)] = -1;
                        continue;
                    }
                    for (int k = 0; k < 2; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= n || nj >= m || grid[ni][nj] == '0') continue;
                        unionSet(index(i, j), index(ni, nj));
                    }
                }
            }
            int numOfIslands = 0;
            for (int i = 0; i < len; i++) {
                if (parent[i] != -1 && find(i) == i) numOfIslands++;
            }
            return numOfIslands;
        }

        /**
         * 将二维坐标转换为一维下标
         *
         * @param i 纵坐标
         * @param j 横坐标
         * @return 下标
         */
        private int index(int i, int j) {
            return i * m + j;
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
         * 地图的高、宽
         */
        private int n, m;

        /**
         * parent[i] 为结点 i 的父结点
         */
        private int[] parent;

        /**
         * 方向数组
         */
        int[] dx = {1, 0};
        int[] dy = {0, 1};
    }

    static class DFS implements Solution {

        /**
         * n、m 分别为 grid 的高和宽 <br>
         * 时间复杂度：O(nm) <br>
         * 空间复杂度：O(1) <br>
         */
        @Override
        public int numIslands(char[][] grid) {
            this.n = grid.length;
            this.m = grid[0].length;
            this.numOfIslands = 0;
            this.grid = grid;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j);
                        numOfIslands++;
                    }
                }
            }
            return numOfIslands;
        }

        /**
         * 深度优先搜索，将连通的区域置为 '0'
         *
         * @param x 纵坐标
         * @param y 横坐标
         */
        private void dfs(int x, int y) {
            if (x < 0 || x == n || y < 0 || y == m || grid[x][y] == '0') return;
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
        }

        /**
         * 岛屿的数量
         */
        int numOfIslands;
        /**
         * 地图的高、宽
         */
        int n, m;
        /**
         * 地图
         */
        char[][] grid;

        /**
         * 方向数组
         */
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
    }
}
