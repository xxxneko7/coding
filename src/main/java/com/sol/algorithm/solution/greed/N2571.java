package com.sol.algorithm.solution.greed;

public class N2571 {
    public static void main(String[] args) {
        System.out.println(new N2571().minOperations(533));
    }

    static int[] arr = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072};

    public int minOperations(int n) {
        int index = ceilIndex(n);
        int ceil = arr[index];
        if (ceil == n) return 1;
        int floor = arr[index - 1];
        int min = Math.min(n - floor, ceil - n);
        return minOperations(min) + 1;
    }

    private int ceilIndex(int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target <= arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
