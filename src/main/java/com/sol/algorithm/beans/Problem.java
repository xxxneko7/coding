package com.sol.algorithm.beans;

import com.sol.algorithm.beans.Solution;

public class Problem {
    public Solution solution;

    public Problem(com.sol.algorithm.beans.Solution solution) {
        this.solution = solution;
    }

    public void run() {
        solution.solve();
    }
}
