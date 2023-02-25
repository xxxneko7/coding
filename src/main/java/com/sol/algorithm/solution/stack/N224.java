package com.sol.algorithm.solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class N224 {
    private Map<Character, Integer> rank = new HashMap<Character, Integer>() {{
        put('*', 2);
        put('/', 2);
        put('+', 1);
        put('-', 1);
        put('(', 0);
    }};

    private Map<Character, BiFunction<Integer, Integer, Integer>> calc = new HashMap<Character, BiFunction<Integer, Integer, Integer>>() {{
        put('+', (x, y) -> y + x);
        put('-', (x, y) -> y - x);
        put('*', (x, y) -> y * x);
        put('/', (x, y) -> y / x);
    }};


    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (' ' == c) continue;

            if (Character.isDigit(c)) {
                number.append(c);
                continue;
            }

            if (number.length() != 0) {
                numbers.push(Integer.parseInt(number.toString()));
                number.setLength(0);
            } else if ('-' == c && ((!ops.isEmpty() && '(' == ops.peek()) || numbers.isEmpty())) {
                numbers.push(0);
                ops.push(c);
                continue;
            }

            if (')' == c) {
                while (!ops.isEmpty()) {
                    char op = ops.pop();
                    if ('(' == op) break;
                    eval(numbers, op);
                }
                continue;
            }

            if ('(' != c && !ops.isEmpty() && rank.get(ops.peek()) >= rank.get(c)) {
                eval(numbers, ops.pop());
            }
            ops.push(c);
        }

        if (number.length() != 0) numbers.push(Integer.parseInt(number.toString()));
        while (!ops.isEmpty()) eval(numbers, ops.pop());
        return numbers.pop();
    }

    private void eval(Stack<Integer> numbers, char op) {
        numbers.push(calc.get(op).apply(numbers.pop(), numbers.pop()));
    }

    public static void main(String[] args) {
        N224 solution = new N224();
        System.out.println(solution.calculate("(7)-(0)+(4)"));
    }
}