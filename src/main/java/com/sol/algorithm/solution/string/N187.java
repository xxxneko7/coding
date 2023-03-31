package com.sol.algorithm.solution.string;

import java.util.*;

public class N187 {


    public static void main(String[] args) {
        System.out.println(new N187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < REPEATED_DNA_LENGTH) return new ArrayList<>();
        int hash = 0;
        for (int i = 0; i < REPEATED_DNA_LENGTH - 1; i++) {
            hash = (hash << 2) | table.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = REPEATED_DNA_LENGTH - 1; i < s.length(); i++) {
            hash = ((hash & H) << 2) | table.get(s.charAt(i));
            cnt.put(hash, cnt.getOrDefault(hash, 0) + 1);
            if (cnt.get(hash) == 2) res.add(s.substring(i - REPEATED_DNA_LENGTH + 1, i + 1));
        }
        return res;
    }

    static final int REPEATED_DNA_LENGTH = 10;
    static final int H = (1 << 18) - 1;
    static Map<Character, Integer> table = new HashMap<>();

    static {
        table.put('A', 0);
        table.put('C', 1);
        table.put('G', 2);
        table.put('T', 3);
    }
}
