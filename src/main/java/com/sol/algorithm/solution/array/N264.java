package com.sol.algorithm.solution.array;

import java.io.FilterInputStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * <a href='https://leetcode.cn/problems/ugly-number-ii/'>264. 丑数 II</a>
 */
public class N264 {
    public static void main(String[] args) {
        N264 solution = new N264();
        System.out.println(solution.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        for (int i = 1; i < n; i++) {
            int p2 = uglyNums[m2] * 2;
            int p3 = uglyNums[m3] * 3;
            int p5 = uglyNums[m5] * 5;
            if (p2 <= p3 && p2 <= p5) {
                m2++;
                uglyNums[i] = p2;
            }
            if (p3 <= p2 && p3 <= p5) {
                m3++;
                uglyNums[i] = p3;
            }
            if (p5 <= p3 && p5 <= p2) {
                m5++;
                uglyNums[i] = p5;
            }
        }
        return uglyNums[n - 1];
    }
}
