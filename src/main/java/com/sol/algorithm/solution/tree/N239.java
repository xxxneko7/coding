package com.sol.algorithm.solution.tree;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class N239 {
    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;
        System.out.println(Arrays.toString(new N239().maxSlidingWindow(nums, k)));
    }

    /**
     * @param nums 整数数组
     * @param k    滑动窗口大小
     * @return 滑动窗口中的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!indexes.isEmpty() && indexes.getFirst() <= i - k) indexes.removeFirst();
            while (!indexes.isEmpty() && nums[indexes.getLast()] <= nums[i]) indexes.removeLast();
            indexes.addLast(i);
            if (i >= k - 1) ans[i - (k - 1)] = nums[indexes.getFirst()];
        }
        return ans;
    }

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        SortedMap<Integer, Integer> numToCount = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            int num = nums[i];
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[n - k + 1];
        for (int i = k - 1, j = 0; i < n; i++, j++) {
            int r = nums[i];
            numToCount.put(r, numToCount.getOrDefault(r, 0) + 1);

            ans[j] = numToCount.firstKey();

            int l = nums[j];
            if (numToCount.get(l) == 1) {
                numToCount.remove(l);
            } else {
                numToCount.put(l, numToCount.get(l) - 1);
            }
        }

        return ans;
    }*/
}
