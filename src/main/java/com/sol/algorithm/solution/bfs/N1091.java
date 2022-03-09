package com.sol.algorithm.solution.bfs;

import java.util.*;

/**
 * 1091. 二进制矩阵中的最短路径
 */
public class N1091 {
    public static void main(String[] args) {
        // 4 
        // int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        // -1
        // int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        // 2
        int[][] grid = {{0, 1}, {1, 0}};
        Solution solution = new BFS();
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }

    public static abstract class Solution {
        /**
         * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
         * <li> 路径途经的所有单元格都的值都是 0 </li>
         * <li> 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）</li>
         *
         * @param grid 二进制矩阵
         * @return 最短 畅通路径 的长度
         */
        abstract int shortestPathBinaryMatrix(int[][] grid);

        /**
         * 初始化
         *
         * @param grid 二进制矩阵
         */
        int init(int[][] grid) {
            this.n = grid.length;
            if (grid[0][0] == 1) return -1;
            if (grid[n - 1][n - 1] == 1) return -1;
            if (n == 1) return 1;

            this.extendedGrid = extendGrid(grid);
            this.start = new Integer[]{1, 1};
            this.target = new Integer[]{n, n};
            return 0;
        }

        /**
         * 扩展 grid，使得原矩阵被 1 包裹
         *
         * @param grid 二进制矩阵
         * @return 扩展后的新矩阵
         */
        int[][] extendGrid(int[][] grid) {
            int[][] temp = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                temp[0][i] = 1;
                temp[n + 1][i] = 1;
                temp[i][0] = 1;
                temp[i][n + 1] = 1;
            }

            for (int i = 0; i < n; i++) {
                System.arraycopy(grid[i], 0, temp[i + 1], 1, n);
            }

            return temp;
        }


        /**
         * 二进制矩阵
         */
        int[][] extendedGrid;
        /**
         * 起始位置
         */
        Integer[] start;
        /**
         * 目标位置
         */
        Integer[] target;
        /**
         * grid 的长宽
         */
        int n;
        /**
         * 方向数组 [→, ↓, ←, ↑, ↘, ↗, ↙, ↖]
         */
        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    }

    /**
     * 普通广度优先搜索
     */
    public static class BFS extends Solution {

        /**
         * n 为 grid 的长宽
         * <li> 时间复杂度：O(n^2) </li>
         * <li> 空间复杂度：O(n^2) </li>
         */
        @Override
        public int shortestPathBinaryMatrix(int[][] grid) {
            int init = init(grid);
            if (init != 0) return init;

            grid = extendGrid(grid);

            Integer[] start = new Integer[]{1, 1};
            Integer[] target = new Integer[]{n, n};
            Queue<Integer[]> queue = new LinkedList<>();
            queue.offer(start);
            // 添加空对象作为连续两层之间的隔断
            queue.offer(null);
            int depth = 1;

            while (!queue.isEmpty()) {
                Integer[] pos = queue.poll();
                if (pos == null) {
                    // 下一层为空时退出
                    if (queue.peek() == null) break;
                    // 不为空时深度加 1，并添加新的隔断
                    depth++;
                    queue.offer(null);
                    continue;
                }
                grid[pos[0]][pos[1]] = 1;
                for (int i = 0; i < dx.length; i++) {
                    Integer[] next = new Integer[]{pos[0] + dx[i], pos[1] + dy[i]};
                    if (grid[next[0]][next[1]] == 1) continue;
                    if (next[0].equals(target[0]) && next[1].equals(target[1])) return depth + 1;
                    queue.offer(next);
                }
            }

            return -1;
        }
    }

    /**
     * 双向广度优先搜索
     */
    public static class BiBFS extends Solution {

        /**
         * n 为 grid 的长宽
         * <li> 时间复杂度：O(n^2) </li>
         * <li> 空间复杂度：O(n^2) </li>
         */
        @Override
        public int shortestPathBinaryMatrix(int[][] grid) {
            int init = init(grid);
            if (init != 0) return init;

            forwardQueue = new LinkedList<>();
            forwardQueue.offer(start);
            forwardIdxToDepth = new HashMap<>();
            forwardIdxToDepth.put(index(start), 1);

            reverseQueue = new LinkedList<>();
            reverseQueue.offer(target);
            reverseIdxToDepth = new HashMap<>();
            reverseIdxToDepth.put(index(target), 1);

            while (!forwardQueue.isEmpty() && !reverseQueue.isEmpty()) {
                int res = expend(forwardQueue, forwardIdxToDepth, reverseIdxToDepth);
                if (res != -1) return res;
                res = expend(reverseQueue, reverseIdxToDepth, forwardIdxToDepth);
                if (res != -1) return res;
            }
            return -1;
        }

        /**
         * 沿当前方向进行一次扩展
         *
         * @param queue           当前方向的队列
         * @param idxToDepth      当前方向的索引到深度的映射
         * @param otherIdxToDepth 另一方向的索引到深度的映射
         * @return 双向搜索相遇时返回总的深度，否则返回 -1
         */
        int expend(Queue<Integer[]> queue, Map<Integer, Integer> idxToDepth, Map<Integer, Integer> otherIdxToDepth) {
            Integer[] pos = queue.poll();
            int idxOfPos = index(pos);
            for (int i = 0; i < dx.length; i++) {
                Integer[] next = new Integer[]{pos[0] + dx[i], pos[1] + dy[i]};
                int idxOfNext = index(next);
                // 下一个位置为 1 时跳过
                if (extendedGrid[next[0]][next[1]] == 1) continue;
                // 下一个位置在 当前方向 已经访问过时跳过
                if (idxToDepth.containsKey(idxOfNext)) continue;
                // 双向搜索相遇
                if (otherIdxToDepth.containsKey(idxOfNext))
                    return idxToDepth.get(idxOfPos) + otherIdxToDepth.get(idxOfNext);

                idxToDepth.put(idxOfPos, idxToDepth.get(idxOfPos) + 1);
                queue.offer(next);
            }
            return -1;
        }

        /**
         * 坐标转索引
         *
         * @param pos 坐标
         * @return 索引
         */
        int index(Integer[] pos) {
            return pos[0] * n + pos[1];
        }

        /**
         * 正向队列
         */
        Queue<Integer[]> forwardQueue;
        /**
         * 反向队列
         */
        Queue<Integer[]> reverseQueue;
        /**
         * 正向映射
         */
        Map<Integer, Integer> forwardIdxToDepth;
        /**
         * 反向映射
         */
        Map<Integer, Integer> reverseIdxToDepth;
    }

    /**
     * A* 搜索
     */
    public static class Astar extends Solution {

        /**
         * n 为 grid 的长宽
         * <li> 时间复杂度：O(n^2) </li>
         * <li> 空间复杂度：O(n^2) </li>
         */
        @Override
        int shortestPathBinaryMatrix(int[][] grid) {
            int init = init(grid);
            if (init != 0) return init;

            queue = new PriorityQueue<>(Comparator.comparingInt(this::expect));
            queue.offer(start);
            idxToDepth = new HashMap<>();
            idxToDepth.put(index(start), 1);

            int idxOfTarget = index(target);

            while (!queue.isEmpty()) {
                Integer[] pos = queue.poll();
                int idxOfPos = index(pos);
                for (int i = 0; i < dx.length; i++) {
                    Integer[] next = new Integer[]{pos[0] + dx[i], pos[1] + dy[i]};
                    // 下一个位置为 1 时跳过
                    if (extendedGrid[next[0]][next[1]] == 1) continue;
                    int idxOfNext = index(next);
                    // 下一个位置在 当前方向 已经访问过时跳过
                    if (idxToDepth.containsKey(idxOfNext)) continue;
                    // 下一个位置即目标
                    if (idxOfNext == idxOfTarget) return idxToDepth.get(idxOfPos) + 1;

                    idxToDepth.put(idxOfPos, idxToDepth.get(idxOfPos) + 1);
                    queue.offer(next);
                }
            }

            return -1;
        }

        /**
         * 期望函数：
         * pos 到 target 的曼哈顿距离 + pos 的深度
         *
         * @param pos 位置
         * @return 期望值，期望值越小优先级越高
         */
        int expect(Integer[] pos) {
            return target[0] - pos[0] + target[1] - pos[1] + idxToDepth.get(index(pos));
        }

        /**
         * 坐标转索引
         *
         * @param pos 坐标
         * @return 索引
         */
        int index(Integer[] pos) {
            return pos[0] * n + pos[1];
        }

        /**
         * 期望值最小的优先队列
         */
        PriorityQueue<Integer[]> queue;

        /**
         * 位置索引 -> 深度
         */
        Map<Integer, Integer> idxToDepth;
    }
}
