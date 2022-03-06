package com.sol.algorithm.solution.string;

/**
 * 151. 翻转字符串里的单词
 */
public class N151 {
    /**
     * 逐个翻转字符串中的所有 单词
     * <p>
     * n 为字符串长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param s 字符串
     * @return 翻转 s 中单词顺序并用单个空格相连的字符串
     */
    public String reverseWords(String s) {
        StringBuilder wordsReversed = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                word.append(ch);
                continue;
            }
            if (!"".equals(word.toString())) {
                wordsReversed.insert(0, " " + word);
                word = new StringBuilder();
            }
        }
        if (!"".equals(word.toString())) wordsReversed.insert(0, word);
        else wordsReversed.deleteCharAt(0);
        return wordsReversed.toString();
    }
}
