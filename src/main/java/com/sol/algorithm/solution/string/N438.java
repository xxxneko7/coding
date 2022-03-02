package com.sol.algorithm.solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 438.
 */
public class N438 {
    public static void main(String[] args) {
        System.out.println(new N438().findAnagrams("cbaebabacd", "abc"));
    }

    List<Integer> findAnagrams(String s, String p) {
        char[] charsOfS = s.toCharArray();
        char[] charsOfP = p.toCharArray();
        int n = charsOfP.length - 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < charsOfS.length; i++) {
            for (int k = n; k >= 0; k--) {

            }
        }
        return ans;
    }
}
