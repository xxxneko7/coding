package com.sol.algorithm.solutions.linkedList;

import com.sol.algorithm.structure.ListNode;

/**
 * 206. 反转链表
 */
public class N206 {

    /**
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     */
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
