package com.sol.algorithm.solution.dp;

import java.util.Arrays;

/**
 * 1706. 球会落何处
 *
 *
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 */
public class N1706 {
    public static void main(String[] args) {
        // [1,-1,-1,-1,-1]
        int[][] grid = new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(new N1706().findBall(grid)));
    }

    /**
     * <li> 时间复杂度：O(m*n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param grid 网格
     * @return answer[i]
     */
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = i;

        for (int[] columns : grid) {
            for (int j = 0; j < n; j++) {
                int cur = answer[j];
                if (cur == -1) continue;
                if (columns[cur] == 1) {
                    int next = cur + 1;
                    if (next < n && columns[next] != -1) answer[j] = next;
                    else answer[j] = -1;
                } else {
                    int next = cur - 1;
                    if (next >= 0 && columns[next] != 1) answer[j] = next;
                    else answer[j] = -1;
                }
            }
        }

        return answer;
    }
}
