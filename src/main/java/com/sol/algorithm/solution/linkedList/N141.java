package com.sol.algorithm.solution.linkedList;

import com.sol.algorithm.structure.ListNode;

/**
 * 141. 环形链表
 */
public class N141 {

    /**
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode f, s;
        s = f = head;
        while (f != null) {
            f = f.next == null ? null : f.next.next;
            s = s.next;
            // 快慢指针相遇则有环
            if (f == s) return true;
        }
        return false;
    }
}
