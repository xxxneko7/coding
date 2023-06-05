package com.sol.algorithm.solution.string;

import java.util.List;

public class N524 {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
        for (String word : dictionary) {
            int i = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != word.charAt(i)) continue;
                i++;
                if (i == word.length()) return word;
            }
        }
        return "";
    }
}