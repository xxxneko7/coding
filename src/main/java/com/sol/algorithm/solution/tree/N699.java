package com.sol.algorithm.solution.tree;

import java.util.List;

/**
 * 699. 掉落的方块
 */
public class N699 {
    public static void main(String[] args) {
        // [1, 10, 18]
        int[][] positions = {{2, 1}, {2, 9}, {1, 8}};
        System.out.println(new N699().fallingSquares(positions));
    }

    /**
     * @param positions 第 i 个掉落的方块（positions[i] = (left, side_length)）
     * @return 堆叠高度列表
     */
    public List<Integer> fallingSquares(int[][] positions) {
        return null;
    }

    /**
     * 线段树
     */
    class SegmentTree {
        int N, H;
        int[] tree, lazy;

        SegmentTree(int N) {
            this.N = N;
            H = 1;
            while ((1 << H) < N) H++;
            tree = new int[2 * N];
            lazy = new int[N];
        }

        private void apply(int x, int val) {
            tree[x] = Math.max(tree[x], val);
            if (x < N) lazy[x] = Math.max(lazy[x], val);
        }

        private void pull(int x) {
            while (x > 1) {
                x >>= 1;
                tree[x] = Math.max(tree[x * 2], tree[x * 2 + 1]);
                tree[x] = Math.max(tree[x], lazy[x]);
            }
        }

        private void push(int x) {
            for (int h = H; h > 0; h--) {
                int y = x >> h;
                if (lazy[y] > 0) {
                    apply(y * 2, lazy[y]);
                    apply(y * 2 + 1, lazy[y]);
                    lazy[y] = 0;
                }
            }
        }

        public void update(int L, int R, int h) {
            L += N;
            R += N;
            int L0 = L, R0 = R, ans = 0;
            while (L <= R) {
                if ((L & 1) == 1) apply(L++, h);
                if ((R & 1) == 0) apply(R--, h);
                L >>= 1;
                R >>= 1;
            }
            pull(L0);
            pull(R0);
        }

        public int query(int L, int R) {
            L += N;
            R += N;
            int ans = 0;
            push(L);
            push(R);
            while (L <= R) {
                if ((L & 1) == 1) ans = Math.max(ans, tree[L++]);
                if ((R & 1) == 0) ans = Math.max(ans, tree[R--]);
                L >>= 1;
                R >>= 1;
            }
            return ans;
        }
    }
}
