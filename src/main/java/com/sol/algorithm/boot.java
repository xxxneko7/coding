package com.sol.algorithm;

import com.sol.algorithm.beans.Solution;
import com.sol.algorithm.beans.Subject;
import com.sol.algorithm.subject.linkedList.N21;

public class boot {
    public static void main(String[] args) {
        Solution solution = new N21();
        Subject subject = new Subject(solution);
        subject.run();
    }
}
