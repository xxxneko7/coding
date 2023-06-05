package com.sol.algorithm.solution.linkedlist;

import com.sol.algorithm.structure.ListNode;
import com.sol.algorithm.util.LinkedListUtil;

public class N147 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.create(new int[]{5, 6, 1, 10, 9});
        N147 solution = new N147();
        LinkedListUtil.print(solution.insertionSortList(head));
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head.next;
        ListNode tail = head;
        while (curr != null) {
            ListNode prev = dummy;
            while (prev.next != curr && prev.next.val < curr.val) {
                prev = prev.next;
            }
            if (prev.next == curr) {
                tail = curr;
            } else {
                tail.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = tail.next;
        }
        return dummy.next;
    }
}
