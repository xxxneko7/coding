package com.sol.algorithm.solution.string;

public class N43 {
    public static void main(String[] args) {
        System.out.println(new N43().multiply("52", "60"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res[0] == 0 ? 1 : 0; i < m + n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
