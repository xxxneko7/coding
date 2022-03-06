package com.sol.algorithm.solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class N438 {
    public static void main(String[] args) {
        System.out.println(new N438().findAnagrams("ba", "a"));
    }

    /**
     * n、m 分别为 strs 的长度 和 strs 中最长字符串的长度
     * <li> 时间复杂度：O(n + m) </li>
     * <li> 空间复杂度：O(字符集大小) </li>
     *
     * @param s 字符串
     * @param p 字符串
     * @return s 中所有 p 的 异位词子串 的起始索引
     */
    List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        if (n < m) return new ArrayList<>();

        int[] table = new int[26];
        for (int i = 0; i < m; i++) {
            table[s.charAt(i) - 'a']++;
            table[p.charAt(i) - 'a']--;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) differ++;
        }

        List<Integer> ans = new ArrayList<>();
        if (differ == 0) ans.add(0);

        for (int l = 0; l < n - m; l++) {
            int kl = s.charAt(l) - 'a';
            if (table[kl] == 1) differ--;
            else if (table[kl] == 0) differ++;
            table[kl]--;

            int kr = s.charAt(l + m) - 'a';
            if (table[kr] == -1) differ--;
            else if (table[kr] == 0) differ++;
            table[kr]++;

            if (differ == 0) ans.add(l + 1);
        }
        return ans;
    }
}
