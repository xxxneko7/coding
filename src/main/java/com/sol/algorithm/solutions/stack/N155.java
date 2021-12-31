package com.sol.algorithm.solutions.stack;

import com.sol.algorithm.beans.Solution;

import java.util.Stack;

public class N155 implements Solution {
    @Override
    public void solve() {

    }

    class MinStack {
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
            return values.pop();
        }

        public int getMin() {
            return values.elementAt(indexesOfMinVal.peek());
        }
    }
}
