package com.sol.algorithm.solution.map;

import java.util.*;

public class N49 {
    public static void main(String[] args) {
        System.out.println(new N49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            String key = groupFunc(s);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    private String groupFunc(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    /*private String groupFunc(String s) {
        // int[] 作为 Map 的 key，是以数组的地址为 hash值，不能达到分组的目的
        int[] key = new int[26];
        s.chars().forEach(letter -> key[letter - 'a']++);
        return Arrays.toString(key);
    }*/
}
