package com.sol.algorithm.solution.binarysearch;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 */
public class N154 {

    public static void main(String[] args) {
        System.out.println(new N154().findMin(new int[]{4, 1, 1}));
    }

    /**
     * 返回数组的最小值 <br>
     * 数组为【升序数组】旋转多次后的数组（可能存在重复元素）<br>
     * 数组 [a[0], a[1], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], ..., a[n-2]]
     * <p>
     * n 为数组长度 <br>
     * - 时间复杂度：O(log(m * n)) <br>
     * - 空间复杂度：O(1) <br>
     *
     * @param nums 数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        // nums[0] < nums[n-1] 说明数组旋转了 n 次恢复为【升序数组】
        if (nums[0] < nums[n - 1]) return nums[0];
        // 二分查找 min(nums) = nums[t]
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                // nums[m] < nums[r] => t ∈ (l, m]
                r = m;
            } else if (nums[m] > nums[r]) {
                // nums[m] > nums[r] => t ∈ (m, r]
                l = m + 1;
            } else {
                // nums[m] == nums[r] => t ∈ [l, r)
                r--;
            }
        }
        return nums[l];
    }
}
