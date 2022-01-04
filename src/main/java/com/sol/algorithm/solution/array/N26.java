package com.sol.algorithm.solution.array;

/**
 * 26. 删除有序数组中的重复项
 */
public class N26 {
    /**
     * <li>时间复杂度：O(n)</li>
     * <li>空间复杂度：O(1)</li>
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int lenWithoutDuplicates = 1;
        for (int i = 1; i < nums.length; i++) {
            // 当前项与前一项不同时，将当前项放在【无重复项数组】的末位
            if (nums[i] != nums[i - 1]) {
                nums[lenWithoutDuplicates++] = nums[i];
            }
        }
        return lenWithoutDuplicates;
    }
}
