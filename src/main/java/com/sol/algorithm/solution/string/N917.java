package com.sol.algorithm.solution.string;

/**
 * 917. 仅仅反转字母
 */
public class N917 {
    public static void main(String[] args) {
        System.out.println(new N917().reverseOnlyLetters("ab-cd"));
    }

    /**
     * n 为字符串长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param s 字符串
     * @return 将 s 中的字母反转之后的字符串
     */
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        // 首尾添加哨兵 避免数组越界判断
        char[] chars = new char[n + 2];
        System.arraycopy(s.toCharArray(), 0, chars, 1, n);
        chars[0] = chars[n + 1] = 'Z';

        for (int l = 1, r = n; l < r; l++, r--) {
            // 跳过非字母字符
            while (!isLetter(chars[l])) l++;
            while (!isLetter(chars[r])) r--;
            // 字母交换
            if (l < r) {
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
            }
        }
        return new String(chars, 1, n);
    }

    /**
     * 字符是否是字母（包括大小写）
     *
     * @param ch 字符
     * @return 是否是字母
     */
    public boolean isLetter(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }
}
