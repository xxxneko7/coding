package com.sol.algorithm.solutions.stack;

import com.sol.algorithm.beans.Solution;

import java.util.Stack;

public class N150 implements Solution {
    @Override
    public void solve() {

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                numbers.push(calc(numbers.pop(), numbers.pop(), token));
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.peek();
    }

    private int calc(int y, int x, String op) {
        if ("+".equals(op)) return x + y;
        if ("-".equals(op)) return x - y;
        if ("*".equals(op)) return x * y;
        if ("/".equals(op)) return x / y;
        return 0;
    }
}
