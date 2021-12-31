package com.sol.algorithm.solutions.stack;

import com.sol.algorithm.beans.Solution;
import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Stack;

public class N84 implements Solution {
    @Override
    public void solve() {

    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> minHeights = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (!minHeights.isEmpty() && minHeights.peek()[0] > height) {
                maxArea = Math.max(maxArea, calcMaxArea(minHeights, i));
            }
            minHeights.push(new int[]{height, i});
        }
        maxArea = Math.max(maxArea, calcMaxArea(minHeights, heights.length));
        return maxArea;
    }

    private int calcMaxArea(Stack<int[]> minHeights, int r) {
        int maxArea = 0;
        while (!minHeights.isEmpty()) {
            int[] height_idx = minHeights.pop();
            maxArea = Math.max(maxArea, calcArea(height_idx[1], r, height_idx[0]));
        }
        return maxArea;
    }

    private int calcArea(int l, int r, int minHeight) {
        return (r - l) * minHeight;
    }

}
