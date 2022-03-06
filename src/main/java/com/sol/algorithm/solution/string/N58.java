package com.sol.algorithm.solution.string;

/**
 * 58. 最后一个单词的长度
 */
public class N58 {
    /**
     * n 为字符串的长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param s 若干单词组成的字符串（单词间用' '隔开）
     * @return 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        int n = s.length();
        // 最后一个单词位于 s[l, r]
        int r = n - 1;
        while (r >= 0 && s.charAt(r) == ' ') r--;
        int l = r - 1;
        while (l >= 0 && s.charAt(l) != ' ') l--;
        return r - l + 1;
    }
}
