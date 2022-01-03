package com.sol.algorithm.solutions.stack;


import java.util.Stack;

import static java.lang.System.out;

public class N227 {
    public static void main(String[] args) {
        N227 solution = new N227();
        out.println(solution.calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                number.append(c);
                continue;
            }
            if (' ' == c) {
                continue;
            }
            numbers.push(Integer.parseInt(number.toString()));
            number.delete(0, number.length());
            while (!ops.isEmpty() && getRank(ops.peek()) >= getRank(c)) {
                numbers.push(calc(numbers.pop(), numbers.pop(), ops.pop()));
            }
            ops.push(c);
        }
        numbers.push(Integer.parseInt(number.toString()));
        while (!ops.isEmpty()) {
            numbers.push(calc(numbers.pop(), numbers.pop(), ops.pop()));
        }
        return numbers.pop();
    }

    private int getRank(char op) {
        if ('*' == op || '/' == op) return 2;
        if ('+' == op || '-' == op) return 1;
        return 0;
    }

    private int calc(int y, int x, char op) {
        if ('+' == op) return x + y;
        if ('-' == op) return x - y;
        if ('*' == op) return x * y;
        if ('/' == op) return x / y;
        return 0;
    }
}
