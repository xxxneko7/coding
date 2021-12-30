package com.sol.algorithm.solutions.stack;

import com.sol.algorithm.beans.Solution;

import java.util.Stack;

public class N20 implements Solution {
    @Override
    public void solve() {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (!pair(stack.pop(), c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean pair(char l, char r) {
        return (l == '{' && r == '}') || (l == '[' && r == ']') || (l == '(' && r == ')');
    }
}
