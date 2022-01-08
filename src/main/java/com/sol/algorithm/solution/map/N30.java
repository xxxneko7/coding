package com.sol.algorithm.solution.map;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 */
public class N30 {
    /**
     * s 的字符数组
     */
    private char[] chars;

    /**
     * 单词长度
     */
    private int lenOfWord;

    /**
     * 统计单词出现次数的映射
     */
    Map<String, Integer> wordToNum;

    /**
     * - 时间复杂度：O()
     * - 空间复杂度：O()
     *
     * @param s     字符串
     * @param words 单词数组 - 数组中单词长度相同
     * @return s 中恰好可以由 words 中所有单词串联形成的子串的起始位置 - 不需要考虑 words 中单词串联的顺序
     */
    public List<Integer> findSubstring(String s, String[] words) {
        wordToNum = new HashMap<>(words.length);
        Arrays.stream(words).forEach(word -> wordToNum.put(word, wordToNum.getOrDefault(word, 0) + 1));
        chars = s.toCharArray();
        lenOfWord = words[0].length();
        int lenOfSubString = lenOfWord * words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= chars.length - lenOfSubString; i++) {
            if (validSubstring(i, i + lenOfSubString)) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 验证 chars 的子串是否有效
     *
     * @param start 子串的起始位置
     * @param end   子串的结束位置
     * @return true: 有效 | false: 无效
     */
    private boolean validSubstring(int start, int end) {
        Map<String, Integer> splitWordToNum = new HashMap<>(wordToNum.size());
        for (int i = start; i + lenOfWord <= end; i += lenOfWord) {
            String splitWord = new String(Arrays.copyOfRange(chars, i, i + lenOfWord));
            splitWordToNum.put(splitWord, splitWordToNum.getOrDefault(splitWord, 0) + 1);
        }
        return compareMap(splitWordToNum, wordToNum);
    }

    /**
     * 比较两个集合
     *
     * @param a 集合A
     * @param b 集合B
     * @return true: 相同 | false: 不同
     */
    private <K, V> boolean compareMap(Map<K, V> a, Map<K, V> b) {
        return a.entrySet().containsAll(b.entrySet());
    }
}
