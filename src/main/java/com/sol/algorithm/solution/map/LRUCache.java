package com.sol.algorithm.solution.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
public class LRUCache {

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity + 1, 1);
        this.capacity = capacity;
        this.head = new BiListNode();
        this.tail = new BiListNode();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        BiListNode node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        BiListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        node = new BiListNode(key, value);
        if (size == capacity) {
            map.remove(head.next.key);
            remove(head.next);
        } else {
            size++;
        }
        map.put(key, node);
        insert(node);
    }

    private void insert(BiListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    private void remove(BiListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    /**
     * 头结点
     */
    private BiListNode head;

    /**
     * 尾节点
     */
    private BiListNode tail;

    /**
     * 键值映射
     */
    private Map<Integer, BiListNode> map;

    /**
     * 缓存容量
     */
    private int capacity;

    /**
     * 当前大小
     */
    private int size;

    /**
     * 双向链表节点
     */
    private class BiListNode {
        /**
         * 键
         */
        public int key;
        /**
         * 值
         */
        public int val;
        /**
         * 后继节点
         */
        public BiListNode next;
        /**
         * 前驱节点
         */
        public BiListNode pre;

        public BiListNode() {
        }

        public BiListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
