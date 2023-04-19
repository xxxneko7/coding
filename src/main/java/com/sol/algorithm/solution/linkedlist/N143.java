package com.sol.algorithm.solution.linkedlist;

import com.sol.algorithm.structure.ListNode;
import com.sol.algorithm.util.LinkedListUtil;

public class N143 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.create(new int[]{1, 2, 3, 4, 5});
        N143 solution = new N143();
        solution.reorderList(head);
        LinkedListUtil.print(head);
    }

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode seq = head, rev = pre;
        while (seq != rev && seq.next != rev) {
            ListNode seqNext = seq.next;
            ListNode revNext = rev.next;
            seq.next = rev;
            rev.next = seqNext;
            seq = seqNext;
            rev = revNext;
        }
        rev.next = null;
    }
}
