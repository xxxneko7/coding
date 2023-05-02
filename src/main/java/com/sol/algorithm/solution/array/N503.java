package com.sol.algorithm.solution.array;

import java.util.Arrays;
import java.util.Stack;

public class N503 {
    public static void main(String[] args) {
        N503 solution = new N503();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 3, 2, 1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            int item = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[item]) {
                res[stack.pop()] = nums[item];
            }
            stack.push(item);
        }
        return res;
    }
}
