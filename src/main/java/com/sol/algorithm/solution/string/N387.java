package com.sol.algorithm.solution.string;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class N387 {
    /**
     * n 为字符串的长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param s 字符串
     * @return s 中第一个不重复的字符的索引，不存在时返回 -1
     */
    public int firstUniqChar(String s) {
        int ans = s.length();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idxOfCh = s.indexOf(ch);
            if (idxOfCh == -1)  continue;
            if (idxOfCh == s.lastIndexOf(ch))
                ans = Math.min(ans, idxOfCh);
        }
        return ans == s.length() ? -1 : ans;
    }
}
