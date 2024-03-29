package com.sol.algorithm.solution.linkedlist;


import com.sol.algorithm.structure.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class N21 {
    /**
     * 迭代
     * <p>
     * n、m分别为【list1】、【list2】的长度
     * <li>时间复杂度：O(n+m)</li>
     * <li>空间复杂度：O(1)</li>
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        ListNode head = cur;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return head.next;
    }

    /**
     * 递归
     * <p>
     * n、m分别为【list1】、【list2】的长度
     * <li>时间复杂度：O(n+m)</li>
     * <li>空间复杂度：O(n+m)</li>
     */
    /*
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }*/
}
