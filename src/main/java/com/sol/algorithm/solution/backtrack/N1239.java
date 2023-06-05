package com.sol.algorithm.solution.backtrack;

import java.util.*;

public class N1239 {
    public static void main(String[] args) {
         List<String> arr = Arrays.asList("cha", "r", "act", "ers");
//        List<String> arr = Arrays.asList("aa", "bb");
        N1239 solution = new N1239();
        System.out.println(solution.maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                if ((1 << c & mask) > 0) {
                    mask = 0;
                    break;
                }
                mask |= (1 << c);
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        backtrack(masks, 0, 0);
        return maxLen;
    }

    int maxLen = 0;

    private void backtrack(List<Integer> masks, int cur, Integer mask) {
        if (cur == masks.size()) {
            maxLen = Math.max(maxLen, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(cur)) == 0) {
            backtrack(masks, cur + 1, mask | masks.get(cur));
        }
        backtrack(masks, cur + 1, mask);
    }
}
