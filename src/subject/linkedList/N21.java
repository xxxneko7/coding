package subject.linkedList;

import beans.Solution;
import structure.ListNode;
import utils.LinkedListUtil;

public class N21 implements Solution {
    @Override
    public void solve() {
        ListNode list1 = LinkedListUtil.create(new int[]{1, 3, 4});
        ListNode list2 = LinkedListUtil.create(new int[]{1, 2, 4});
        ListNode head = mergeTwoLists(list1, list2);
        LinkedListUtil.print(head);
    }

    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    }*/

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
    }
}
