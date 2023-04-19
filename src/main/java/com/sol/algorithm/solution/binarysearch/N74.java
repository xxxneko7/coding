package com.sol.algorithm.solution.binarysearch;

/**
 * 74. 搜索二维矩阵
 */
public class N74 {
    public static void main(String[] args) {
        System.out.println(new N74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
    }

    /**
     * 搜索矩阵中是否存在目标值。矩阵有如下特性：<br>
     * - 每行中的整数从左到右按升序排列 <br>
     * - 每行的第一个整数大于前一行的最后一个整数 <br>
     * <p>
     * m、n 分别为矩阵的行、列数 <br>
     * - 时间复杂度：O(log(m * n)) <br>
     * - 空间复杂度：O(1) <br>
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return 矩阵中是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 二分查找
        int l = 0, r = n * m;
        while (l < r) {
            // mid = n * row + col
            int mid = (l + r) / 2;
            int val = matrix[mid / n][mid % n];
            if (val < target) {
                l = mid + 1;
            } else if (val > target) {
                r = mid;
            } else {
                return true;
            }
        }
        return false;
    }
}
