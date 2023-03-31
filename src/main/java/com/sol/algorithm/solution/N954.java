package com.sol.algorithm.solution;

import java.util.*;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回
 * false。
 */
public class N954 {
    public static void main(String[] args) {
        int[] arr;
        N954 solution = new N954();

        // false
        arr = new int[]{3, 1, 3, 6};
        System.out.println(solution.canReorderDoubled(arr));

        // true
        arr = new int[]{4, -2, 2, -4, 4, 8, 8, 16};
        System.out.println(solution.canReorderDoubled(arr));

        // false
        arr = new int[]{-5, -3};
        System.out.println(solution.canReorderDoubled(arr));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        arr = Arrays.stream(arr).sorted().toArray();
        for (int i : arr) {
            numToCount.put(i, numToCount.getOrDefault(i, 0) + 1);
        }

        for (int num : arr) {
            int count = numToCount.get(num);
            if (count == 0) continue;
            if (num == 0) {
                if ((count & 1) == 1) return false;
                continue;
            }
            if (num < 0 && (num & 1) == 1) return false;
            int other = num > 0 ? num << 1 : num >> 1;
            if (!numToCount.containsKey(other) || numToCount.get(other) < count) return false;

            numToCount.put(num, 0);
            numToCount.put(other, numToCount.get(other) - count);
        }
        return true;
    }
}
