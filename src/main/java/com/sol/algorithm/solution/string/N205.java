package com.sol.algorithm.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 */
public class N205 {
    /**
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的
     *
     * @param s 字符串
     * @param t 字符串
     * @return s 和 t 是否同构
     */
    public boolean isIsomorphic(String s, String t) {
        // s 中字符到 t 中字符的映射
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) == map.get(s.charAt(i))) return false;
            } else if (map.containsValue(t.charAt(i)))
                return false;
            else
                map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
