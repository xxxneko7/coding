package com.sol.algorithm.solution.linkedList;

import com.sol.algorithm.structure.ListNode;

public class N82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) next = next.next;
            if (cur.next != next) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummyHead.next;
    }
}
