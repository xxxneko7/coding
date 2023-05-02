package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">59. 螺旋矩阵 II</a>
 */
public class N59 {
    public static void main(String[] args) {
        int[][] matrix = new N59().generateMatrix(20);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static List<int[]> directions = new ArrayList<>(4);

    static {
        directions.add(new int[]{0, 1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{-1, 0});
    }

    int cursor;

    public int[][] generateMatrix(int n) {
        this.cursor = 0;
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int x = 0, y = 0;
        int num = 1;
        while (true) {
            matrix[x][y] = num++;
            int[] direction = directions.get(cursor);
            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != 0) {
                cursor = ++cursor == directions.size() ? 0 : cursor;
                direction = directions.get(cursor);
                x += direction[0];
                y += direction[1];
                if (matrix[x][y] != 0) return matrix;
            } else {
                x = nx;
                y = ny;
            }
        }
    }
}
