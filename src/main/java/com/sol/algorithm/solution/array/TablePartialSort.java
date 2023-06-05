package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.
 * Input:
 * [[1, 2, 2, 3, 4],
 * [1, 2, 3, 7, 5],
 * [1, 1, 3, 5, 6],
 * [1, 4, 1, 6, 7]]
 * [2, 3, 4, 5]
 * [1, 2]
 * <p>
 * Output:
 * [[1, 2, 2, 3, 4],
 * [1, 2, 1, 6, 7],
 * [1, 1, 3, 5, 6],
 * [1, 4, 3, 7, 5]]
 * <p>
 * 2.
 * Input:
 * [[80, 59, 7, 25],
 * [81, 59, 7, 25],
 * [80, 56, 7, 12],
 * [13, 21, 97, 53]]
 * [1, 1, 3, 3]
 * [3, 1]
 * <p>
 * Output:
 * [[80, 59, 7, 25],
 * [80, 56, 7, 25],
 * [81, 59, 7, 12],
 * [13, 21, 97, 53]]
 */
public class TablePartialSort {
    public static void main(String[] args) {
        int[][] gird = {{80, 59, 7, 25},
                {81, 59, 7, 25},
                {80, 56, 7, 12},
                {13, 21, 97, 53}};
        int[] area = {1, 1, 3, 3};
        int[] sortCols = {3, 1};
        int[][] result = new Solution().process(gird, area, sortCols);

        String outputStr = Arrays.stream(result)
                .map(arr -> {
                    return Arrays.stream(arr)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
                })
                .collect(Collectors.joining("," + System.lineSeparator(), "[", "]"));
        System.out.println(outputStr);
    }
}

class Solution {
    /**
     * @param grid     input matrix
     * @param area     area[0] - top; area[1] - left; area[2] - bottom; area[3] - right;
     * @param sortCols columns
     * @return sorted matrix
     */
    int[][] process(int[][] grid, int[] area, int[] sortCols) {
        List<Integer> rows = new ArrayList<>();
        for (int i = area[0] - 1; i < area[2]; i++) {
            rows.add(i);
        }
        rows = rows.stream().sorted((m1, m2) -> compare(m1, m2, grid, area, sortCols)).collect(Collectors.toList());

        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, n);
        }

        int len = area[3] - area[1] + 1;
        int start = area[1] - 1;
        for (int i = 0; i < rows.size(); i++) {
            int j = area[0] - 1 + i;
            System.arraycopy(grid[rows.get(i)], start, newGrid[j], start, len);
        }
        return newGrid;
    }

    private int compare(Integer m1, Integer m2, int[][] grid, int[] area, int[] sortCols) {
        for (int sortCol : sortCols) {
            int n = area[1] - 1 + sortCol - 1;
            if (grid[m1][n] == grid[m2][n]) continue;
            return grid[m1][n] - grid[m2][n];
        }
        return 0;
    }

}

