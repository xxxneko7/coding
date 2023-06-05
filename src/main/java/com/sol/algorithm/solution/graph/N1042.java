package com.sol.algorithm.solution.graph;

import java.util.*;

public class N1042 {
    /**
     * 每个花园 最多 有 3 条路径可以进入或离开 => 花园的 入度最多为 3
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] paths = {{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}};
        N1042 solution = new N1042();
        System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] neighbours = new List[n];
        for (int[] path : paths) {
            int i, j;
            if (path[0] < path[1]) {
                i = path[0] - 1;
                j = path[1] - 1;
            } else {
                i = path[1] - 1;
                j = path[0] - 1;
            }
            if (neighbours[j] == null) neighbours[j] = new ArrayList<>();
            neighbours[j].add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            if (neighbours[i] == null) continue;
            int k = 0;
            for (Integer neighbour : neighbours[i]) {
                k = k | (1 << res[neighbour] - 1);
            }
            k = k ^ 15;
            res[i] = map.get(k & -k);
        }
        return res;
    }

    static Map<Integer, Integer> map = new HashMap<>(4);

    static {
        map.put(1, 1);
        map.put(2, 2);
        map.put(4, 3);
        map.put(8, 4);
    }
}
