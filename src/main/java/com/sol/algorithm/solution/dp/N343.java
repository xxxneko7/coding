package com.sol.algorithm.solution.dp;

public class N343 {
    public static void main(String[] args) {
        System.out.println(new N343().integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        // 2f - 4 >= f, 当且仅当 f = 4 时取等， 所以最佳分解为 尽可能多的 3 并补充 2
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
