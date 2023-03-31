package com.sol.algorithm.solution.stack;


import java.util.Stack;

public class N155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.top();
        System.out.println(minStack.getMin());
    }

    static class MinStack {
        Stack<Integer> values;
        Stack<Integer> indexesOfMinVal;

        public MinStack() {
            values = new Stack<>();
            indexesOfMinVal = new Stack<>();
        }

        public void push(int val) {
            if (indexesOfMinVal.isEmpty()) {
                indexesOfMinVal.push(0);
            } else if (val < getMin()) {
                indexesOfMinVal.push(values.size());
            }
            values.push(val);
        }

        public void pop() {
            values.pop();
            if (values.size() == indexesOfMinVal.peek()) {
                indexesOfMinVal.pop();
            }
        }

        public int top() {
            return values.peek();
        }

        public int getMin() {
            return values.elementAt(indexesOfMinVal.peek());
        }
    }
}
