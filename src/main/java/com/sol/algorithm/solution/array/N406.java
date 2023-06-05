package com.sol.algorithm.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N406 {
    /**
     * [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * sort => [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
     * for & insert => {
     *     1. [[7, 0]]
     *     2. [[7, 0], [7, 1]]
     *     3. [[7, 0], [6, 1], [7, 1]]
     *     4. [[5, 0], [7, 0], [6, 1], [7, 1]]
     *     5. ...
     * }
     */
    public static void main(String[] args) {
        N406 solution = new N406();
        String s = "[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]";
        int[][] people = Arrays.stream(s.substring(2, s.length() - 2).split("],\\[")).map(sub -> Arrays.stream(sub.split(",")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> queue = new ArrayList<>(people.length);
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
