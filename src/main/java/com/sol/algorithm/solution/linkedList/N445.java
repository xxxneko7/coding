package com.sol.algorithm.solution.linkedList;

import com.sol.algorithm.structure.ListNode;

import java.util.Stack;

public class N445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        ListNode cur = null, pre = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = carry + num1 + num2;
            carry = sum / 10;
            cur = new ListNode(sum % 10, pre);
            pre = cur;
        }
        if (carry == 1) cur = new ListNode(1, pre);

        return cur;
    }
}
