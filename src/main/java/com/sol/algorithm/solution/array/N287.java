package com.sol.algorithm.solution.array;

public class N287 {
    public static void main(String[] args) {
        System.out.println(new N287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
