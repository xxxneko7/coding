package com.sol.algorithm.solution.string;

/**
 * 917. 仅仅反转字母
 */
public class N917 {
    public static void main(String[] args) {
        System.out.println(new N917().reverseOnlyLetters("ab-cd"));
    }

    /**
     * @param s 字符串
     * @return 将 s 中的字母反转之后的字符串
     */
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] chars = new char[n + 2];
        System.arraycopy(s.toCharArray(), 0, chars, 1, n);
        chars[0] = chars[n + 1] = 'Z';

        for (int l = 1, r = n; l < r; l++, r--) {
            while (!isLetter(chars[l])) l++;
            while (!isLetter(chars[r])) r--;
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
