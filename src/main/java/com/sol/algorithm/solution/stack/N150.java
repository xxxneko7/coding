package com.sol.algorithm.solution.stack;


import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.function.BiFunction;

public class N150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (ops.containsKey(token)) {
                numbers.push(ops.get(token).apply(numbers.pop(), numbers.pop()));
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.peek();
    }

    private Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<String, BiFunction<Integer, Integer, Integer>>() {{
        put("+", (x, y) -> y + x);
        put("-", (x, y) -> y - x);
        put("*", (x, y) -> y * x);
        put("/", (x, y) -> y / x);
    }};
}
