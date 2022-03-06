package com.sol.algorithm.solution.string;

/**
 * 541. 反转字符串 II
 */
public class N541 {
    /**
     * 从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 <br>
     * - 如果剩余字符少于 k 个，则将剩余字符全部反转。 <br>
     * - 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样 <br>
     * <p>
     * n 为字符串长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param s 字符串
     * @param k k
     * @return 反转字符串
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0;
        for (; l < n - 2 * k + 1; l += 2 * k) {
            // r - l + 1 = k
            reverse(chars, l, l + k - 1);
        }
        reverse(chars, l, k < n - l ? l + k - 1 : n - 1);
        return new String(chars);
    }

    /**
     * 反转 chars[l...r] 之间的字符
     *
     * @param chars 字符数组
     * @param l     左边界
     * @param r     右边界
     */
    private void reverse(char[] chars, int l, int r) {
        while (l < r)
            switchChar(chars, l++, r--);
    }

    /**
     * 交换字符
     *
     * @param chars 字符数组
     * @param idx1  位置1
     * @param idx2  位置2
     */
    private void switchChar(char[] chars, int idx1, int idx2) {
        char temp = chars[idx1];
        chars[idx1] = chars[idx2];
        chars[idx2] = temp;
    }
}
