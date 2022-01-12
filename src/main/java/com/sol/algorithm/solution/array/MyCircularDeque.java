package com.sol.algorithm.solution.array;


/**
 * 641. 设计循环双端队列
 */
public class MyCircularDeque {

    private int[] container;
    private int head, tail;

    /**
     * 容器保留一个空位，用来区分队列【空】和【满】
     * <p>
     * 【head】指向队首元素，【tail】指向队尾元素
     */
    public MyCircularDeque(int k) {
        container = new int[k + 1];
        head = 1;
        tail = 0;
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
        tail = moveBackward(tail);
        container[tail] = value;
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
            return -1;
        }
        return container[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return container[tail];
    }

    public boolean isEmpty() {
        return head == moveBackward(tail);
    }

    public boolean isFull() {
        return moveBackward(tail) == moveForward(head);
    }

    public int getLength() {
        int len = tail - head + 1;
        return len >= 0 ? len : container.length + len;
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
