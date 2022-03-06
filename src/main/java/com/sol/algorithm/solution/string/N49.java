package com.sol.algorithm.solution.string;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class N49 {
    public static void main(String[] args) {
        System.out.println(new N49().groupAnagrams(new String[]{"abc"}));
    }

    /**
     * n、m 分别为 strs 的长度 和 strs 中字符串的平均长度
     * <li> 时间复杂度：O(n * m) </li>
     * <li> 空间复杂度：O(字符集大小) </li>
     *
     * @param strs 字符串
     * @return 字母异位词分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashToAnagrams = new HashMap<>();
        for (String s : strs) {
            String key = hash(s);
            if (!hashToAnagrams.containsKey(key)) hashToAnagrams.put(key, new ArrayList<>());
            hashToAnagrams.get(key).add(s);
        }
        return new ArrayList<>(hashToAnagrams.values());
    }

    /**
     * @param s 字符串
     * @return s 的哈希值
     */
    private String hash(String s) {
        char[] table = new char[26];
        for (char ch : s.toCharArray()) {
            table[ch - 'a']++;
        }
        return new String(table);
    }
}
