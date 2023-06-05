package com.sol.algorithm.solution.string;

import java.util.Deque;
import java.util.LinkedList;

public class N402 {
    public static void main(String[] args) {
        System.out.println(new N402().removeKdigits("100012", 1));
    }

    public String removeKdigits(String num, int k) {
        // 保留下来的数
        Deque<Character> deque = new LinkedList<>();
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            char digit = num.charAt(i);

            // 当新数字比保留数的最后一位更大时，移除保留数的最后一位一定能获得收益
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        // 移除的数不足 k 个时，从后往前移除
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder res = new StringBuilder();
        // 跳过前导 0, 队列中的其他数组成答案
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
