package com.sol.algorithm.solution.string;

import java.util.Deque;
import java.util.LinkedList;

public class N402 {
    public static void main(String[] args) {
        System.out.println(new N402().removeKdigits("100012", 1));
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder res = new StringBuilder();
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
