package com.sol.algorithm.solution.string;

/**
 * 344. 反转字符串
 */
public class N344 {
    /**
     * 原地反转字符串
     * <p>
     * n 为字符串长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param s 字符串
     */
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
