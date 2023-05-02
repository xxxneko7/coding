package com.sol.algorithm.solution.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class N720 {
    public String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>();
        set.add("");
        List<String> wordList = Arrays.stream(words).sorted((w1, w2) -> w1.length() == w2.length() ? w1.compareTo(w2) : w1.length() - w2.length()).collect(Collectors.toList());
        for (String word : wordList) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < word.length()) {
                if (set.contains(sb.toString())) sb.append(word.charAt(i++));
                else break;
            }
            if (i == word.length()) {
                set.add(sb.toString());
                if (sb.length() > res.length()) res = sb.toString();
            }
        }
        return res;
    }
}
