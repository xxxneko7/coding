package com.sol.algorithm.solution.bfs;

import java.util.*;

/**
 * 210. 课程表 II
 */
public class N210 {
    public static void main(String[] args) {
        Solution solution = new DFS();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})));
    }

    public interface Solution {
        /**
         * 找到在约束条件下可以学完所有课程的学习顺序
         *
         * @param numCourses    待学课程数量 - 课程编号从 0 到 (numCourses - 1)
         * @param prerequisites 选课约束 - prerequisites[i] = [a_i, b_i] ，表示在选修课程 a_i 前 必须 先选修 b_i
         * @return 可以学完所有课程的学习顺序，不存在时返回空数组
         */
        int[] findOrder(int numCourses, int[][] prerequisites);
    }

    public static class DFS implements Solution {
        /**
         * 课程到【可选课程】的映射，因为课程编号在 [0, n - 1] 的范围内，所以使用 List 即可
         */
        private List<List<Integer>> courseToOptionals;

        /**
         * 深度优先搜索时课程的访问状态，0: 未访问 | 1: 处理中 | 2: 已处理
         */
        private int[] visited;

        /**
         * 选修顺序数组，按顺序记录选修课程的编号
         */
        private int[] res;

        /**
         * 正在处理的选修顺序
         */
        private int cur;

        /**
         * 是否存在可行的选课顺序
         */
        private boolean valid;

        /**
         * n、m分别为课程数量和约束条件的数量 <br>
         * - 时间复杂度：O(n+m) <br>
         * - 空间复杂度：O(n+m) <br>
         */
        @Override
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            courseToOptionals = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                courseToOptionals.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                courseToOptionals.get(prerequisite[1]).add(prerequisite[0]);
            }
            visited = new int[numCourses];
            res = new int[numCourses];
            // 【dfs】从后往前记录学习顺序
            cur = numCourses - 1;
            valid = true;
            // 遍历处理【未处理】状态的课程
            for (int course = 0; course < numCourses; course++) {
                if (visited[course] == 0) {
                    dfs(course);
                }
                if (!valid) {
                    return new int[0];
                }
            }
            return res;
        }

        /**
         * 深度优先搜索，从后往前将课程添加到学习顺序数组中
         *
         * @param course 课程编号
         */
        private void dfs(int course) {
            // 【处理中】
            visited[course] = 1;
            // 遍历该课程的【可选课程】
            for (int optional : courseToOptionals.get(course)) {
                if (visited[optional] == 0) {
                    // 遇到【未访问】的课程继续搜索
                    dfs(optional);
                } else if (visited[optional] == 1) {
                    // 遇到【处理中】的课程说明选课约束存在环，无法得到可行的选课顺序
                    valid = false;
                }
                if (!valid) {
                    return;
                }
            }
            // 【已处理】
            visited[course] = 2;
            // 从后往前添加课程，则【可选课程】的学习顺序都在该课程的学习顺序之后
            res[cur--] = course;
        }
    }

    public static class BFS implements Solution {
        /**
         * 课程编号到可选课程的映射
         */
        private List<List<Integer>> courseToOptionals;

        /**
         * 记录每个课程的【前置课程】数量
         */
        private int[] prerequisiteNumOfCourses;

        /**
         * 学习顺序数组，按顺序记录学习课程的编号
         */
        private int[] res;

        /**
         * 正在处理的学习顺序
         */
        private int cur;

        /**
         * n、m分别为待学课程数量和约束条件的数量 <br>
         * - 时间复杂度：O(n+m) <br>
         * - 空间复杂度：O(n+m) <br>
         */
        @Override
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            courseToOptionals = new ArrayList<>(numCourses);
            prerequisiteNumOfCourses = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courseToOptionals.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                courseToOptionals.get(prerequisite[1]).add(prerequisite[0]);
                prerequisiteNumOfCourses[prerequisite[0]]++;
            }
            res = new int[numCourses];
            // 【bfs】从前往后记录学习顺序
            cur = 0;
            // 利用队列保存没有【前置课程】要求的课程，实现广度优先搜索
            Queue<Integer> coursesWithoutPrerequisite = new LinkedList<>();
            for (int i = 0; i < prerequisiteNumOfCourses.length; i++) {
                if (prerequisiteNumOfCourses[i] == 0) {
                    coursesWithoutPrerequisite.offer(i);
                }
            }

            while (!coursesWithoutPrerequisite.isEmpty()) {
                int course = coursesWithoutPrerequisite.poll();
                res[cur++] = course;
                // 遍历该课程的【可选课程】
                for (int optional : courseToOptionals.get(course)) {
                    prerequisiteNumOfCourses[optional]--;
                    if (prerequisiteNumOfCourses[optional] == 0) {
                        coursesWithoutPrerequisite.offer(optional);
                    }
                }
            }
            if (cur != numCourses) {
                return new int[0];
            }
            return res;
        }
    }
}
