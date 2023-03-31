package com.sol.algorithm.solution;

/**
 * 796. 旋转字符串
 */
public class N796 {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        // true
        System.out.println(new N796().rotateString(s, goal));

        s = "abcde";
        goal = "abced";
        // false
        System.out.println(new N796().rotateString(s, goal));
    }

    public boolean rotateString(String str, String goal) {
        int n = str.length(), m = goal.length();
        if (n != m) return false;

        char[] t = goal.toCharArray();
        int[] next = new int[m];
        // "ababc"
        // 匹配模式串 t
        for (int i = 1, l = 0; i < m; i++) {
            while (l > 0 && t[i] != t[l + 1]) l = next[l];
            if (t[i] == t[l]) l++;
            next[i] = l;
        }

        char[] s = new char[n];
        // 匹配文本串 s
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && (j == m || s[i] != t[j + 1])) j = next[j];
            if (s[i] == t[j + 1]) j++;
            // t 在 s 中出现
            // if (f[i] == m)
        }
        return false;
    }
}
