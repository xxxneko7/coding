package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> queue = new ArrayList<>(people.length);
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
