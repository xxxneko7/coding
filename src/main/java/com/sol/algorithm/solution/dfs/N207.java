package com.sol.algorithm.solution.dfs;

import java.util.ArrayList;
import java.util.List;

public class N207 {
    List<List<Integer>> edges;
    // visited[]: 0 - 未搜索; 1 - 搜索中; 2 - 搜索完成
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) dfs(i);
        }

        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 2) continue;
            if (visited[v] == 1) {
                valid = false;
                return;
            }
            dfs(v);
            if (!valid) return;
        }
        visited[u] = 2;
    }
}
