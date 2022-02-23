package com.sol.algorithm.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class N120 {
    /**
     * 给定一个三角形 triangle，找出自顶向下的最小路径和 <br>
     * 对于当前位置 cur，每次只能选择下一层的 cur 或 cur + 1
     * <p>
     * n 为三角形的层数 <br>
     * 时间复杂度：O(n^2) <br>
     * 空间复杂度：O(n) <br>
     *
     * @param triangle 三角形
     * @return 最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> minTotal = triangle.get(n - 1);
        for (int d = n - 2; d >= 0; d--) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> layer = triangle.get(d);
            for (int i = 0; i < layer.size(); i++) {
                temp.add(layer.get(i) + Math.min(minTotal.get(i), minTotal.get(i + 1)));
            }
            minTotal = temp;
        }
        return minTotal.get(0);
    }
}
