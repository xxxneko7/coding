package com.sol.algorithm.solution.stack;


import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class N20 {

    /**
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                // 左括号入栈
                stack.push(c);
            } else {
                // 右括号匹配最近的左括号
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
