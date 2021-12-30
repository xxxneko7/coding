package com.sol.algorithm.solutions.linkedList;

import com.sol.algorithm.beans.Solution;
import com.sol.algorithm.structure.ListNode;
import com.sol.algorithm.utils.LinkedListUtil;

public class N206 implements Solution {
    @Override
    public void solve() {
        ListNode head = LinkedListUtil.create(new int[]{1, 2, 3});
        head = reverseList(head);
        LinkedListUtil.print(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode last = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }
}
