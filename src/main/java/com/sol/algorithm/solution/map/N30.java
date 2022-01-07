package com.sol.algorithm.solution.map;

import java.util.*;

public class N30 {
    public static void main(String[] args) {
        System.out.println(new N30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordToNum = new HashMap<>(words.length);
        Arrays.stream(words).forEach(word -> wordToNum.put(word, wordToNum.getOrDefault(word, 0) + 1));
        char[] chars = s.toCharArray();
        int lenOfWord = words[0].length();
        int lenOfSubString = lenOfWord * words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= chars.length - lenOfSubString; ) {
            if (validSubstring(chars, i, i + lenOfSubString, lenOfWord, wordToNum)) {
                res.add(i);
                i += lenOfWord;
            } else {
                i++;
            }
        }
        return res;
    }

    private boolean validSubstring(char[] chars, int start, int end, int lenOfWord, Map<String, Integer> wordToNum) {
        Map<String, Integer> splitWordToNum = new HashMap<>(wordToNum.size());
        for (int i = start; i + lenOfWord <= end; i += lenOfWord) {
            String splitWord = new String(Arrays.copyOfRange(chars, i, i + lenOfWord));
            splitWordToNum.put(splitWord, splitWordToNum.getOrDefault(splitWord, 0) + 1);
        }
        return compareMap(splitWordToNum, wordToNum);
    }

    private boolean compareMap(Map<String, Integer> a, Map<String, Integer> b) {
        return a.entrySet().containsAll(b.entrySet());
    }
}
