package com.sol.algorithm.solution.set;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class N874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obs = Arrays.stream(obstacles).map(this::hashFunc).collect(Collectors.toSet());
        int x = 0, y = 0;
        // N: 0 | E: 1 | S: 2 | W: 3
        int dir = 0;
        // 方向数组 [N, E, S, W]
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int maxDistance = 0;
        for (int command : commands) {
            if (command == -1) {
                // 右转
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                // 左转
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir], ny = y + dy[dir];
                    if (obs.contains(hashFunc(new int[]{nx, ny}))) {
                        // 如果前进方向有障碍物
                        break;
                    }
                    x = nx;
                    y = ny;
                }
                maxDistance = Math.max(maxDistance, x * x + y * y);
            }
        }
        return maxDistance;
    }

    private long hashFunc(int[] obstacle) {
        return (obstacle[0] + 30000) * 60001L + (obstacle[1] + 30000);
    }
}
