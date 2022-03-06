package com.sol.algorithm.solution.string;

/**
 * 686. 重复叠加字符串匹配
 */
public class N686 {
    public static void main(String[] args) {
        // abcdabcdabcd
        String repeat = "a";
        String substring = "aa";
        System.out.println(new N686().repeatedStringMatch(repeat, substring));
    }

    /**
     * n、m 分别为字符串 a 和 b 的长度
     * <li> 时间复杂度：O(n + m) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param a 字符串
     * @param b 字符串
     * @return 重复叠加字符串 a，使得字符串 b 是叠加后字符串的子串，返回最小叠加次数，不存在时返回 -1
     */
    public int repeatedStringMatch(String a, String b) {
        int n = a.length(), m = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (n - index >= m) {
            return 1;
        }
        return (m + index - n - 1) / n + 2;
    }

    /**
     * 重复叠加 unit 字符串，使得字符串 substring 是叠加后字符串的子串
     *
     * @param unit      重复叠加的单位字符串
     * @param substring 子串
     * @return substring 在 unit 重复叠加后的字符串中出现的第一个位置，不存在时返回 -1
     */
    public int strStr(String unit, String substring) {
        int n = unit.length(), m = substring.length();
        int b = 131, p = (int) 1e9 + 7;
        // 计算 substring 的哈希值
        long hashOfSubstring = 0;
        for (char ch : substring.toCharArray()) {
            hashOfSubstring = (hashOfSubstring * b + ch) % p;
        }
        // 通过 i % n 循环取 unit 中的字符组成字符串，计算其长度为 m - 1 时的哈希值
        long hashOfRepeat = 0, powBM = 1;
        for (int i = 0; i < m - 1; i++) {
            hashOfRepeat = (hashOfRepeat * b + unit.charAt(i % n)) % p;
            powBM = powBM * b % p;
        }
        // 如果 substring 的首字母不在 unit 字符串中，则 substring 不会出现在 unit 重复叠加后的字符串中
        // 即 从 i = m - 1 开始继续取 unit 中的字符拼接成 repeat(长度为 m)，重复 n 次
        for (int i = m - 1; i < n + m - 1; i++) {
            hashOfRepeat = (hashOfRepeat * b + unit.charAt(i % n)) % p;
            if (hashOfRepeat == hashOfSubstring) return i - m + 1;
            hashOfRepeat = (hashOfRepeat - unit.charAt((i - m + 1) % n) * powBM) % p;
            hashOfRepeat = (hashOfRepeat + p) % p;
        }
        return -1;
    }
}
