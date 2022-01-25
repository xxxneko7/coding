package com.sol.algorithm.solution.dfs;

/**
 * 130. 被围绕的区域
 */
public class N130 {
    /**
     * m、n 分别为 board 的行、列数 <br>
     * - 时间复杂度：O(m * n) <br>
     * - 空间复杂度：O(m * n) <br>
     */
    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        // 遍历边界
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        // 遍历棋盘，将 'A' 还原为 'O'，'O' 置为 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    /**
     * 深度优先搜索，将相连的 'O' 置为 'A'
     *
     * @param row 行
     * @param col 列
     */
    private void dfs(int row, int col) {
        if (row == -1 || row == m || col == -1 || col == n || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'A';
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

    /**
     * 棋盘
     */
    private char[][] board;

    /**
     * 行、列数
     */
    private int m, n;
}
