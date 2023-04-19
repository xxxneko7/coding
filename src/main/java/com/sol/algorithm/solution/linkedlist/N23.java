package com.sol.algorithm.solution.linkedlist;

import com.sol.algorithm.structure.ListNode;
import com.sol.algorithm.util.LinkedListUtil;

import java.util.*;

/**
 * 23. 合并K个升序链表
 */
public class N23 {

    public static void main(String[] args) {
        Solution solution = new HeapSort();
        int[][] input = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[input.length];
        int i = 0;
        for (int[] list : input) {
            lists[i++] = LinkedListUtil.create(list);
        }
        LinkedListUtil.print(solution.mergeKLists(lists));
    }

    public interface Solution {
        /**
         * 将多个升序排列的链表合并成一个
         *
         * @param lists 升序链表数组
         * @return 合并后的升序链表
         */
        ListNode mergeKLists(ListNode[] lists);
    }

    public static class HeapSort implements Solution {
        /**
         * k为链表数量，n为 k 个链表中的最大长度 <br>
         * - 时间复杂度：O(k * n * log_k)，最多有 k * n 个需要操作的节点，优先队列插入、删除操作时间复杂度为 log_k <br>
         * - 空间复杂度：O(k) <br>
         */
        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            // 利用【优先队列】将 k 个链表的头结点排序
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length + 1, Comparator.comparingInt(node -> node.val));
            Arrays.stream(lists).filter(Objects::nonNull).forEach(pq::offer);
            ListNode head = new ListNode();
            ListNode cur = head;
            while (!pq.isEmpty()) {
                cur.next = pq.poll();
                cur = cur.next;
                if (Objects.nonNull(cur.next)) pq.offer(cur.next);
            }
            return head.next;
        }
    }

    public static class DivideAndConquer implements Solution {
        ListNode[] lists;

        /**
         * k为链表数量，n为 k 个链表中的最大长度 <br>
         * - 时间复杂度：O(k * n * log_k)，递归树的每一层都要处理 k * n 个节点的合并，时间复杂度为 O(k * n)，递归深度为 log_k <br>
         * - 空间复杂度：O(n * log_k)，递归的空间复杂度为递归的深度，合并两个升序链表为 O(n)，分治为 O(log_k) <br>
         */
        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) {
                return null;
            }
            this.lists = lists;
            return merge(0, n - 1);
        }

        /**
         * 合并区间 lists[left, right] 内的链表
         *
         * @param left  左边界
         * @param right 右边界
         * @return 合并后的升序链表
         */
        private ListNode merge(int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = (right + left) >> 1;
            return merge2Lists(merge(left, mid), merge(mid + 1, right));
        }

        /**
         * 合并两个升序链表
         *
         * @param list1 升序链表1
         * @param list2 升序链表2
         * @return 合并后的升序链表
         */
        private ListNode merge2Lists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val < list2.val) {
                list1.next = merge2Lists(list1.next, list2);
                return list1;
            } else {
                list2.next = merge2Lists(list1, list2.next);
                return list2;
            }
        }
    }
}
