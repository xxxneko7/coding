package com.sol.algorithm.solution.array;

public class N378 {
    /**
     * 1  3  5
     * 6  7  12
     * 11 14 14
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(matrix, mid, k, n)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int count = 0;
        for (int i = n - 1, j = 0; 0 <= i && j < n; ) {
            if (matrix[i][j] <= mid) {
                count += (i + 1);
                j++;
            } else i--;
        }
        return count >= k;
    }
}
