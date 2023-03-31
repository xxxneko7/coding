package com.sol.algorithm.solution.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同二叉搜索树的个数
 */
public class N96 {
    public static void main(String[] args) {
        System.out.println(new N96().numTrees(5));
    }

    public int numTrees(int n) {
        return dfs(n);
    }

    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 1);
        map.put(1, 1);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += dfs(i - 1) * dfs(n - i);
        }
        map.put(n, res);
        return res;
    }
}
