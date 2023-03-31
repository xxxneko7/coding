package com.sol.algorithm.solution.linkedList;

import com.sol.algorithm.structure.ListNode;

public class N234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        if (fast != null) slow = slow.next;
        while (pre != null && slow != null) {
            if (pre.val != slow.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
