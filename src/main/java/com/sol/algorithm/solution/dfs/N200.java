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
        System.out.println(new N200().numIslands(grid));
    }

    /**
     * n、m 分别为 grid 的高和宽 <br>
     * 时间复杂度：O(nm) <br>
     * 空间复杂度：O(1) <br>
     *
     * @param grid 地图
     * @return 岛屿数量
     */
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
