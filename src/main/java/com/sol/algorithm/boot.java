package com.sol.algorithm;

import com.sol.algorithm.beans.Solution;
import com.sol.algorithm.beans.Problem;
import com.sol.algorithm.solutions.linkedList.N21;

public class boot {
    public static void main(String[] args) {
        Solution solution = new N21();
        Problem problem = new Problem(solution);
        problem.run();
    }
}
