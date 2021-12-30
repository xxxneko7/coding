package com.sol.algorithm.solutions.stack;

import com.sol.algorithm.beans.Solution;

import java.util.Stack;

public class N150 implements Solution {
    @Override
    public void solve() {

    }

    public long evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                stack.push(calc(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Long.parseLong(token));
            }
        }
        return stack.peek();
    }

    private long calc(long x, long y, String op) {
        if ("+".equals(op)) return x + y;
        if ("-".equals(op)) return x - y;
        if ("*".equals(op)) return x * y;
        if ("/".equals(op)) return x / y;
        return 0;
    }
}
