package com.sol.algorithm.solution.bfs;

import java.util.*;

/**
 * 210. 课程表 II
 */
public class N210 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N210().findOrder(2, new int[][]{{1, 0}})));
    }

    /**
     * n为待学课程数量 <br>
     * - 时间复杂度：O(n*n!) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param numCourses    待学课程数量
     * @param prerequisites 选课约束 - prerequisites[i] = [a_i, b_i] ，表示在选修课程 a_i 前 必须 先选修 b_i
     * @return 可以学完所有课程的学习顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>(numCourses);
        Set<Integer> optional = new HashSet<>(numCourses + 1, 1);
        Set<Integer> learned;
        for (int i = 0; i < numCourses; i++) {
            optional.add(i);
        }
        for (int[] prerequisite : prerequisites) {
            optional.remove(prerequisite[0]);
        }
        learned = optional;
        res.addAll(learned);
        while (res.size() != numCourses) {
            optional = new HashSet<>();
            for (int[] prerequisite : prerequisites) {
                if (learned.contains(prerequisite[1])) {
                    optional.add(prerequisite[0]);
                }
            }
            res.addAll(optional);
            learned = optional;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
