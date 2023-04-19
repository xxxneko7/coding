package com.sol.algorithm.solution.linkedlist;

import com.sol.algorithm.structure.ListNode;

public class N142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
