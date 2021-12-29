package utils;

import structure.ListNode;

public class LinkedListUtil {

    public static ListNode create(int[] data) {
        ListNode head = null;
        for (int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
        return head;
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        ListNode head = create(data);
        print(head);
    }
}
