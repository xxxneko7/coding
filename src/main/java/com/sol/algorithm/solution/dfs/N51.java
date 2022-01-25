package com.sol.algorithm.solution.dfs;

import java.util.*;

/**
 * 51. N 皇后
 */
public class N51 {
    public static void main(String[] args) {
        Solution solution = new DFSByHashSet();
        List<List<String>> res = solution.solveNQueens(4);
        res.forEach(System.out::println);
    }

    public abstract static class Solution {
        /**
         * N 皇后问题的可行解，结果用 [[".Q..","...Q","Q...","..Q."], ...] 的格式保存，其中 "." 表示一个格子，"Q" 表示皇后
         *
         * @param n 皇后的个数
         * @return N 皇后问题的解法
         */
        abstract List<List<String>> solveNQueens(int n);

        /**
         * 格式化解法
         *
         * @return 格式化后的解
         */
        public List<String> formatBoard() {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }


        /**
         * 皇后个数
         */
        int n;
        /**
         * 皇后的位置 (i, queens[i])
         */
        int[] queens;
        /**
         * 结果
         */
        List<List<String>> res;
    }

    /**
     * 通过 {@code HashSet} 记录状态
     */
    public static class DFSByHashSet extends Solution {
        /**
         * n为皇后的个数 <br>
         * - 时间复杂度：O(n!) <br>
         * - 空间复杂度：O(n) <br>
         */
        @Override
        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            res = new ArrayList<>();
            queens = new int[n];
            columns = new HashSet<>(n + 1, 1);
            posDiagonals = new HashSet<>(n + 1, 1);
            negDiagonals = new HashSet<>(n + 1, 1);
            dfs(0);
            return res;
        }

        private void dfs(int row) {
            if (row == n) {
                res.add(formatBoard());
                return;
            }
            for (int col = 0; col < n; col++) {
                int posDiagonal = row - col;
                int negDiagonal = row + col;
                if (columns.contains(col) || posDiagonals.contains(posDiagonal) || negDiagonals.contains(negDiagonal)) {
                    continue;
                }
                queens[row] = col;
                columns.add(col);
                posDiagonals.add(posDiagonal);
                negDiagonals.add(negDiagonal);
                dfs(row + 1);
                columns.remove(col);
                posDiagonals.remove(posDiagonal);
                negDiagonals.remove(negDiagonal);
            }
        }

        private Set<Integer> columns;
        private Set<Integer> posDiagonals;
        private Set<Integer> negDiagonals;
    }

    /**
     * 通过 位运算 记录状态
     */
    public static class DFSByBitOp extends Solution {

        /**
         * n为皇后的个数 <br>
         * - 时间复杂度：O(n!) <br>
         * - 空间复杂度：O(n) <br>
         */
        @Override
        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            res = new ArrayList<>();
            queens = new int[n];
            dfs(0, 0, 0, 0);
            return res;
        }

        /**
         * 深度优先搜索
         * <p>
         * 状态（二进制表示的最低位为棋盘最左列，为 1 的位置表示不可选）：<br>
         * - columns: 记录列方向的位置 <br>
         * - posDiagonals: 记录正对角线位置 <br>
         * - negDiagonals: 记录负对角线位置 <br>
         * <p>
         * 处理下一行时状态更新：<br>
         * - columns: 记录当前行选中的位置 <br>
         * - posDiagonals: 记录当前行选中的位置，并【左移】一位表示下一行正对角线方向不可选的位置 <br>
         * - negDiagonals: 记录当前行选中的位置，并【右移】一位表示下一行负对角线方向不可选的位置 <br>
         *
         * @param row          处理中的行号
         * @param columns      列的位置
         * @param posDiagonals 斜率为正的对角线位置
         * @param negDiagonals 斜率为负的对角线位置
         */
        private void dfs(int row, int columns, int posDiagonals, int negDiagonals) {
            if (row == n) {
                res.add(formatBoard());
                return;
            }
            // 计算可选位置
            int availablePositions = ((1 << n) - 1) & (~(columns | posDiagonals | negDiagonals));
            // 遍历可选位置
            while (availablePositions != 0) {
                // (i & -i) 得到 i 的二进制表示中的最低位的 1 的位置
                int pos = availablePositions & (-availablePositions);
                // 得到列号，Integer.biCount(i) 计算 i 的二进制表示中 1 的个数
                int col = Integer.bitCount(pos - 1);
                queens[row] = col;
                dfs(row + 1, pos | columns, (pos | posDiagonals) << 1, (pos | negDiagonals) >> 1);
                // 更新可选位置
                availablePositions = availablePositions & (availablePositions - 1);
            }
        }
    }


}
