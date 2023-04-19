package com.sol.algorithm.solution.linkedlist;

import com.sol.algorithm.structure.ListNode;
import com.sol.algorithm.util.LinkedListUtil;

public class N148 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.create(new int[]{-1, 5, 3, 4, 0});
        head = new N148().sortList(head);
        LinkedListUtil.print(head);
    }

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyHead, cur = dummyHead.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                // merge(head1, head2), head1 要以 null 结尾
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null) pre = pre.next;
                cur = next;
            }
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode();
        ListNode dummyHead = cur;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 != null ? head1 : head2;
        return dummyHead.next;
    }
}
