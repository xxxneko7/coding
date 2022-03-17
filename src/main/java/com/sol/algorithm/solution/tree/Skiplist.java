package com.sol.algorithm.solution.tree;

import java.util.Random;

/**
 * 1206. 设计跳表
 */
class Skiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        // 返回 false
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        // 返回 true
        System.out.println(skiplist.search(1));
        // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(0));
        // 返回 true
        System.out.println(skiplist.erase(1));
        // 返回 false，1 已被擦除
        System.out.println(skiplist.search(1));
    }

    public Skiplist() {
        this.head = new Node();
        this.levelCount = 0;
    }

    /**
     * 是否存在数据值 target
     *
     * @param target 值
     * @return 存在：true | 不存在：false
     */
    public boolean search(int target) {
        return find(target) != null;
    }

    /**
     * 添加数据
     *
     * @param num 数据值
     */
    public void add(int num) {
        Node node = find(num);
        // 已存在结点则 增加计数
        if (node != null) {
            node.count++;
            return;
        }

        // 不存在结点则 新增
        int level = randomLevel();
        Node newNode = new Node(num, level);

        // 将新结点插入各级索引
        Node[] lower = lowers(num, level);
        for (int i = 0; i < level; i++) {
            newNode.next[i] = lower[i].next[i];
            lower[i].next[i] = newNode;
        }

        // 更新当前层数
        if (levelCount < level) levelCount = level;
    }

    /**
     * 擦除数据
     *
     * @param num 数据值
     * @return 是否成功
     */
    public boolean erase(int num) {
        Node node = find(num);
        if (node == null) return false;

        node.count--;
        if (node.count != 0) return true;

        // 计数为 0 时删除结点，更新各级索引
        int level = node.next.length;
        Node[] lower = lowers(num, level);
        for (int i = 0; i < level; i++) {
            lower[i].next[i] = node.next[i];
        }

        // 更新当前层数
        while (levelCount > 1 && head.next[levelCount] == null) {
            levelCount--;
        }
        return true;
    }

    /**
     * 找到数据值为 target 的结点
     *
     * @param target 值
     * @return 值为 target 的结点，不存在时返回 null
     */
    private Node find(int target) {
        Node lower = lower(target);
        if (lower.next[0] != null && lower.next[0].data == target) {
            return lower.next[0];
        } else {
            return null;
        }
    }

    /**
     * 获取 0 级索引中 小于 target 的最大数据
     *
     * @param target 数据值
     * @return 0 级索引中 小于 target 的最大数据，不存在时返回 null
     */
    private Node lower(int target) {
        Node p = head;
        // 逐级扫描索引
        for (int i = levelCount - 1; i >= 0; i--) {
            // 找到第 i 级中 刚好小于 target 的结点
            while (p.next[i] != null && p.next[i].data < target) {
                p = p.next[i];
            }
        }
        return p;
    }

    /**
     * 获取 [0, level - 1] 级索引中 小于 target 的最大数据
     *
     * @param target 数据值
     * @param level  级数
     * @return [0, level - 1] 级索引中 小于 target 的最大数据，不存在时为 null
     */
    private Node[] lowers(int target, int level) {
        Node[] lowers = new Node[level];
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < target) {
                p = p.next[i];
            }
            lowers[i] = p;
        }
        return lowers;
    }

    /**
     * 以 0.5^i 的概率返回 i，作为数据索引的级数
     *
     * @return 随机级数
     */
    private int randomLevel() {
        int res = 1;
        Random random = new Random();
        while ((random.nextInt(MAX_LEVEL) & 1) == 1) res++;
        return res;
    }

    /**
     * 最大级数
     */
    final static int MAX_LEVEL = 16;
    /**
     * 当前索引级数
     */
    int levelCount;
    /**
     * 头结点
     */
    Node head;

    /**
     * 跳表结点
     */
    public class Node {
        /**
         * 数据值
         */
        private int data;
        /**
         * 数据出现的次数
         */
        private int count;
        /**
         * 保存数据在 [0, MAX_LEVEL - 1] 内每一级的下一个索引结点，不存在时为 null
         */
        private Node[] next;

        /**
         * 数据结点
         *
         * @param data  数据值
         * @param level 数据索引的级数
         */
        Node(int data, int level) {
            this.data = data;
            this.count = 1;
            this.next = new Node[level];
        }

        /**
         * 头结点
         */
        Node() {
            this.data = -1;
            this.count = 0;
            this.next = new Node[MAX_LEVEL];
        }
    }
}