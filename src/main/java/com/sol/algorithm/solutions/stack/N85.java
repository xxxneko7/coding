package com.sol.algorithm.solutions.stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * 85. 最大矩形
 */
public class N85 {
    public static void main(String[] args) {
        N85 solution = new N85();
        System.out.println(solution.maximalRectangle(new char[][]{{'1'}}));
    }

    private int maxArea = 0;
    private int[] heights;

    /**
     * <li>时间复杂度：O(m*n)</li>
     * <li>空间复杂度：O(n)</li>
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 高度单调递增的矩形下标栈
        Stack<Integer> indexes;

        // 首位增加0，作为第一个矩形的左边界，避免在循环中检查栈是否为空
        // 末位增加0，作为最后一个矩形的右边界
        n += 2;
        heights = new int[n];

        for (int i = 0; i < m; i++) {
            indexes = new Stack<>();
            indexes.push(0);
            for (int j = 1; j < n; j++) {
                // 转换每行的高度数组，注意j在【matrix】中的对应
                if (j < n - 1 && matrix[i][j - 1] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
                // 当前高度小于栈顶下标对应的高度时，j为右边界
                calcMaxArea(indexes, j);
                indexes.push(j);
            }
        }
        return maxArea;
    }

    /**
     * 计算高度单调增加的矩形区域的最大面积
     *
     * @param indexes 高度单调增加的矩形下标栈，其 栈底下标对应高度必定小于右边界对应高度
     * @param r       右边界下标
     */
    private void calcMaxArea(Stack<Integer> indexes, int r) {
        while (heights[indexes.peek()] > heights[r]) {
            int height = heights[indexes.pop()];
            // 新的栈顶元素 indexes.peek() 为左边界
            int width = r - indexes.peek() - 1;
            maxArea = Math.max(maxArea, width * height);
        }
    }
}
