package com.sol.algorithm.solution.bitop;

import java.util.Arrays;

public class N338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N338().countBits(5)));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1, j = 0, limit = 1; i <= n; i++) {
            res[i] = res[j++] + 1;
            if (j < limit) continue;
            j = 0;
            limit *= 2;
        }
        return res;
    }
}
