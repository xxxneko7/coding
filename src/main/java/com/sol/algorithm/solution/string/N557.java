package com.sol.algorithm.solution.string;

/**
 * 557. 反转字符串中的单词 III
 */
public class N557 {
    /**
     * 反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序 <br>
     * - s 不包含任何开头或结尾空格 <br>
     * - s 里 至少 有一个词  <br>
     * - s 中的所有单词都用一个空格隔开 <br>
     * <p>
     * n 为字符串长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param s 字符串
     * @return 反转字符串
     */
    public String reverseWords(String s) {
        StringBuilder wordsReversed = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                wordsReversed.append(word).append(" ");
                word = new StringBuilder();
            } else
                word.insert(0, ch);
        }
        wordsReversed.append(word);
        return wordsReversed.toString();
    }
}
