package com.sol.algorithm.solution.array;

public class N153 {
    public static void main(String[] args) {
        N153 solution = new N153();
        System.out.println(solution.findMin(new int[]{5, 6, 7,1}));
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
