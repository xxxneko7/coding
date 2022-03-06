package com.sol.algorithm.solution.string;

/**
 * 14. 最长公共前缀
 */
public class N14 {
    /**
     * n、m 分别为字符串的个数和最短字符串的长度
     * <li> 时间复杂度：O(n * m) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param strs 字符串数组
     * @return strs 中字符串的最长公共前缀，不存在时返回 ""
     */
    public String longestCommonPrefix(String[] strs) {
        for (String str : strs) {
            if (str.length() == 0) return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)) return commonPrefix.toString();
            }
            commonPrefix.append(ch);
        }
        return commonPrefix.toString();
    }
}
