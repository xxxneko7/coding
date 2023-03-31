package com.sol.algorithm.solution.sort;

import java.util.Random;

public class N215 {

    public static void main(String[] args) {
        System.out.println(new N215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    private final Random random = new Random();
    private int p;

    public int findKthLargest(int[] nums, int k) {
        this.p = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1);
    }

    int quickSelect(int[] a, int l, int r) {
        int pivot = partition(a, l, r);
        if (pivot < p) return quickSelect(a, pivot + 1, r);
        if (pivot > p) return quickSelect(a, l, pivot - 1);
        return a[pivot];
    }

    public int partition(int[] a, int l, int r) {
        int pivot = l + random.nextInt(r - l + 1);
        swap(a, pivot, r);
        int x = a[r], i = l;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) swap(a, i++, j);
        }
        swap(a, i, r);
        return i;
    }

    private void swap(int[] a, int l, int r) {
        if (l == r) return;
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        heap.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
                continue;
            }
            if (nums[i] < heap.peek()) continue;
            heap.poll();
            heap.offer(nums[i]);
        }

        return heap.peek();
    }*/

}
