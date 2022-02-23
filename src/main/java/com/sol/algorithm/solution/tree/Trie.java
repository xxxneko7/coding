package com.sol.algorithm.solution.tree;

import java.util.HashMap;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie {

    private class Node {
        int count;
        HashMap<Character, Node> child;

        Node() {
            count = 0;
            child = new HashMap<>();
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * 插入单词
     *
     * @param word 单词
     */
    public void insert(String word) {
        find(word, true, true);
    }

    /**
     * 查询单词
     *
     * @param word 单词
     * @return 单词是否存在
     */
    public boolean search(String word) {
        return find(word, false, false);
    }

    /**
     * 查询以 prefix 为前缀的单词
     *
     * @param prefix 前缀
     * @return 单词是否存在
     */
    public boolean startsWith(String prefix) {
        return find(prefix, false, true);
    }

    /**
     * 查找前缀树
     *
     * @param s        字符串
     * @param isInsert 是否插入
     * @param isPrefix 是否只匹配前缀
     * @return 单词是否存在
     */
    private boolean find(String s, boolean isInsert, boolean isPrefix) {
        Node cur = root;
        for (char ch : s.toCharArray()) {
            if (!cur.child.containsKey(ch)) {
                if (isInsert) {
                    cur.child.put(ch, new Node());
                } else {
                    return false;
                }
            }
            cur = cur.child.get(ch);
        }
        if (isInsert) cur.count++;
        return isPrefix || cur.count > 0;
    }
}
