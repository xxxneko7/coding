package com.sol.algorithm.solution.dfs;

public class N79 {

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, 0);
            }
        }
        return hasWord;
    }

    char[][] board;
    boolean[][] visited;
    String word;
    boolean hasWord = false;
    int m, n;

    private void dfs(int i, int j, int k) {
        if (k == word.length()) hasWord = true;
        if (hasWord) return;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        visited[i][j] = true;
        char c = board[i][j];
        if (c != word.charAt(k)) return;
        dfs(i + 1, j, k + 1);
        dfs(i - 1, j, k + 1);
        dfs(i, j + 1, k + 1);
        dfs(i, j - 1, k + 1);
        visited[i][j] = false;
    }
}
