package com.sol.algorithm.solutions.array;


/**
 * 88. 合并两个有序数组
 */
public class N88 {

    /**
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1, i2, iMerged;
        i1 = m - 1;
        i2 = n - 1;
        iMerged = nums1.length - 1;
        // 从后往前遍历，保证【合并后的数组项】不会覆盖【num1的数组项】
        while (iMerged >= 0 && i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[iMerged] = nums1[i1];
                i1--;
            } else {
                nums1[iMerged] = nums2[i2];
                i2--;
            }
            iMerged--;
        }
        // 【num1】处理结束，【num2】还有剩余时，依次放入【合并后的数组】
        while (i2 >= 0) {
            nums1[iMerged--] = nums2[i2--];
        }
    }
}
