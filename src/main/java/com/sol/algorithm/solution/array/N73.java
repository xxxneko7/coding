package com.sol.algorithm.solution.array;

import java.util.Arrays;

public class N73 {
    public void setZeroes(int[][] matrix) {
        int row = -1;
        int m = matrix.length, n = matrix[0].length;
        start:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    break start;
                }
            }
        }
        if (row == -1) return;
        for (int j = 0; j < n; j++) {
            matrix[row][j] = matrix[row][j] == 0 ? 1 : 0;
        }
        for (int i = row + 1; i < m; i++) {
            boolean hasZero = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    matrix[row][j] = 1;
                }
            }
            if (hasZero) Arrays.fill(matrix[i], 0);
        }
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] == 0) continue;
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
