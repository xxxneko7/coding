package com.sol.algorithm.solution.stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 */
public class N84 {
    public static void main(String[] args) {
        N84 solution = new N84();
        System.out.println(solution.largestRectangleArea(new int[]{2, 4}));
    }


    /**
     * <li>时间复杂度：O(n)</li>
     * <li>空间复杂度：O(n)</li>
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        // 高度单调递增的矩形下标栈
        Stack<Integer> indexes = new Stack<>();

        // 高度数组头尾增加高度为0的哨兵，避免边界判断：
        // 1. 首位增加0，作为第一个矩形的左边界
        // 2. 末位增加0，作为最后一个矩形的右边界
        int[] newHeight;
        newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        indexes.push(0);

        int maxArea = 0;
        for (int i = 1; i < len + 2; i++) {
            while (newHeight[indexes.peek()] > newHeight[i]) {
                int height = newHeight[indexes.pop()];
                int width = i - indexes.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            indexes.push(i);
        }
        return maxArea;
    }
}
