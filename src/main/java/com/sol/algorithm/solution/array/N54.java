package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋遍历矩阵
 */
public class N54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        final int INF = 101;
        List<Integer> res = new ArrayList<>(m * n);
        for (int i = 0, x = 0, y = 0, cursor = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = INF;
            int[] dir = DIRECTIONS[cursor];
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == INF) {
                cursor = (cursor + 1) % DIRECTIONS.length;
                dir = DIRECTIONS[cursor];
                x += dir[0];
                y += dir[1];
            } else {
                x = nx;
                y = ny;
            }
        }
        return res;
    }

    static final int[][] DIRECTIONS = {
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0}
    };
}
