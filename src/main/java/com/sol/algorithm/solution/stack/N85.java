package com.sol.algorithm.solution.stack;


import java.util.Stack;

/**
 * 85. 最大矩形
 */
public class N85 {
    public static void main(String[] args) {
        N85 solution = new N85();
        System.out.println(solution.maximalRectangle(new char[][]{{'1'}}));
    }

    /**
     * 解题思路基于 LeetCode 84. 柱状图中最大的矩形：
     * <p>
     * 横坐标在 (l, r) 内的一个有效矩形，其面积
     * <pre> {@code
     * area = width * height
     *      = (r - l - 1) * Min(heights[h]),
     * 其中， l < h < r 且 heights[l] < heights[h] < heights[r] }
     * </pre>
     * 如果我们确保 (l, r) 之间的矩形高度单调递增，则 Min(heights[h]) = heights[l+1]。
     * 实现时，因为我们从左到右遍历输入矩阵，所以先确定右边界，再动态调整左边界计算有效矩形的面积。
     * <p>
     * m、n分别为【matrix】的行、列数，则 <br/>
     * - 时间复杂度：O(m*n) <br/>
     * - 空间复杂度：O(n) <br/>
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 高度单调递增的矩形下标栈
        Stack<Integer> indexes;

        // 首位增加0，作为第一个矩形的左边界，避免在循环中检查栈是否为空
        // 末位增加0，作为最后一个矩形的右边界
        n += 2;
        int[] heights = new int[n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            indexes = new Stack<>();
            indexes.push(0);
            for (int j = 1; j < n; j++) {
                // 转换每行的高度数组，注意 j 在 matrix 中的对应
                if (j < n - 1 && matrix[i][j - 1] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
                // 当前高度小于栈顶下标对应的高度时，j 为右边界
                while (heights[indexes.peek()] > heights[j]) {
                    int height = heights[indexes.pop()];
                    // 新的栈顶元素 indexes.peek() 为左边界
                    // 这里可以加上条件，找到高度小于待计算矩形的严格左边界：while (heights[indexes.peek()] == height) indexes.pop();
                    int width = j - indexes.peek() - 1;
                    maxArea = Math.max(maxArea, width * height);
                }
                indexes.push(j);
            }
        }
        return maxArea;
    }
}
