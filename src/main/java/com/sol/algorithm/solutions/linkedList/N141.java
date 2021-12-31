package com.sol.algorithm.solutions.linkedList;

import com.sol.algorithm.structure.ListNode;

public class N141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode f, s;
        s = f = head;
        while (f != null) {
            f = f.next == null ? null : f.next.next;
            s = s.next;
            if (f == s) return true;
        }
        return false;
    }
}
