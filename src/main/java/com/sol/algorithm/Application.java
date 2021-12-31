package com.sol.algorithm;

import com.sol.algorithm.beans.Solution;
import com.sol.algorithm.beans.Problem;
import com.sol.algorithm.solutions.linkedList.N21;
import com.sol.algorithm.solutions.stack.N155;
import com.sol.algorithm.solutions.stack.N227;

public class Application {
    public static void main(String[] args) {
        Solution solution = new N227();
        Problem problem = new Problem(solution);
        problem.run();
    }
}
