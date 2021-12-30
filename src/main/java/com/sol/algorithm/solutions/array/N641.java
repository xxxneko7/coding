package com.sol.algorithm.solutions.array;


import com.sol.algorithm.beans.Solution;

public class N641 implements Solution {
    @Override
    public void solve() {

    }

    public class MyCircularDeque {
        private int[] container;
        private int head, tail;

        public MyCircularDeque(int k) {
            container = new int[k + 1];
            head = tail = 0;
        }

        private int moveForward(int cur) {
            return cur > 0 ? cur - 1 : container.length - 1;
        }

        private int moveBackward(int cur) {
            return cur < container.length - 1 ? cur + 1 : 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = moveForward(head);
            container[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            container[tail] = value;
            tail = moveBackward(tail);
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = moveBackward(head);
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = moveForward(tail);
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                throw new RuntimeException("empty");
            }
            return container[head];
        }

        public int getRear() {
            if (isEmpty()) {
                throw new RuntimeException("empty");
            }
            return container[tail - 1];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return moveBackward(tail) == head;
        }

        public int getLength() {
            int len = tail - head;
            return len > 0 ? len : container.length + len;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            int cur = head;
            while (cur != tail - 1) {
                sb.append(container[cur]).append(", ");
                cur = moveBackward(cur);
            }
            sb.append(container[cur]).append("]");
            return sb.toString();
        }
    }
}
