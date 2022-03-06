package com.sol.algorithm.solution.string;

/**
 * 242. 有效的字母异位词
 */
public class N242 {
    public static void main(String[] args) {
        System.out.println(new N242().isAnagram("ac", "bb"));
    }

    /**
     * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
     * <p>
     * n、m 分别为字符串 s 和 t 的长度
     * <li> 时间复杂度：O(n + m) </li>
     * <li> 空间复杂度：O(字符集大小) </li>
     *
     * @param s 字符串
     * @param t 字符串
     * @return t 是否是 s 的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            table[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
