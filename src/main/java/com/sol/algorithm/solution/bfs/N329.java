package com.sol.algorithm.solution.bfs;

/**
 * 329. 矩阵中的最长递增路径
 */
public class N329 {
    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(new N329().longestIncreasingPath(matrix));
    }

    /**
     * <li> 时间复杂度：O(m * n) </li>
     * <li> 空间复杂度：O(m * n) </li>
     *
     * @param matrix m x n 的整数矩阵
     * @return 最长递增路径 的长度
     */
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
        this.lenOfIPFromPos = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }

        return lenOfLIP;
    }

    /**
     * 深度优先搜索
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 从 (x, y) 出发的最长递增路径 长度
     */
    int dfs(int x, int y) {
        int lip = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[x][y] >= matrix[nx][ny])
                continue;
            int lenOfIP = 1 + (lenOfIPFromPos[nx][ny] != 0 ? lenOfIPFromPos[nx][ny] : dfs(nx, ny));
            if (lip < lenOfIP) lip = lenOfIP;
        }
        if (lenOfIPFromPos[x][y] < lip) lenOfIPFromPos[x][y] = lip;
        if (lenOfLIP < lip) lenOfLIP = lip;
        return lip;
    }

    int[][] matrix;
    int[][] lenOfIPFromPos;
    int m, n;
    int lenOfLIP;
    /**
     * 方向数组[→, ↓, ←, ↑]
     */
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
}
