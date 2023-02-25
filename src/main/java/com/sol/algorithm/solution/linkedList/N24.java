package com.sol.algorithm.solution.linkedList;

import com.sol.algorithm.structure.ListNode;

public class N24 {

    private ListNode curr;
    private int k;
    private int i;

    public ListNode reverseKGroup(ListNode head, int k) {
        this.curr = head;
        this.k = k;
        ListNode tail = head;
        head = reverse();
        while (curr != null) {
            ListNode temp = curr;
            tail.next = reverse();
            tail = temp;
        }
        if (i != k) {
            curr = tail.next;
            tail.next = reverse();
        }
        return head;
    }


    private ListNode reverse() {
        ListNode prev = null;
        for (i = 0; i < k && curr != null; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
