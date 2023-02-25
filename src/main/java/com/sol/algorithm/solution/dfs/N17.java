package com.sol.algorithm.solution.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N17 {

    Map<Character, String> numToLetter = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    int depth;
    String digits;
    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        this.depth = digits.length();
        this.digits = digits;
        this.res = new ArrayList<>();
        combineLetter("", 0);
        return res;
    }

    private void combineLetter(String s, int d) {
        if (d == depth) {
            res.add(s);
            return;
        }
        for (char c : numToLetter.get(digits.charAt(d)).toCharArray()) {
            combineLetter(s + c, d + 1);
        }
    }
}
