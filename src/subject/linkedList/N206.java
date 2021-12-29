package subject.linkedList;

import beans.Solution;
import structure.ListNode;
import utils.LinkedListUtil;

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
