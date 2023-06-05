package com.sol.algorithm.solution.greed;

import java.util.Arrays;

public class N134 {
    /**
     * 3 1 1
     * 1 2 2
     * 2 -1 -1
     */
    public int canCompleteCircuit(int[] gases, int[] costs) {
        int gas = 0, idx = -1, lack = 0;
        for (int i = 0; i < gases.length; i++) {
            int delta = gas + gases[i] - costs[i];
            if (delta >= 0) {
                if (gas == 0) {
                    idx = i;
                }
                gas = delta;
            } else {
                gas = 0;
                idx = -1;
                lack += delta;
            }
        }
        return gas + lack >= 0 ? idx : -1;
    }
}
