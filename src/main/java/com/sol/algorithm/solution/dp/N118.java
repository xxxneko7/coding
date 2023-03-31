package com.sol.algorithm.solution.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N118 {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            List<Integer> pre = res.get(i - 1);
            row.add(1);
            for (int j = 1; j < pre.size(); j++) {
                row.add(pre.get(j) + pre.get(j - 1));
            }
            row.add(1);
            res.add(row);

        }
        return res;
    }
}
