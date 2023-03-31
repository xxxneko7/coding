package com.sol.algorithm.solution.dp;

public class N91 {
    /**
     * 1 2 3 4
     * 1 1 2 3
     * 0 1 1 0
     */
    public static void main(String[] args) {
        System.out.println(new N91().numDecodings("1234"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int single = 1, pair = 0;
        for (int i = 1; i < n; i++) {
            int temp = pair;
            int cur = s.charAt(i) - '0';
            int num = (s.charAt(i - 1) - '0') * 10 + cur;
            // update pair
            if (num <= 26) pair = single;
            else if (cur == 0) return 0;
            else pair = 0;

            // update single
            if (cur != 0) single = single + temp;
            else single = 0;
        }
        return single + pair;
    }
}
