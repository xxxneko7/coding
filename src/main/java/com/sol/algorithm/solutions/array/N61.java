package com.sol.algorithm.solutions.array;


import com.sol.algorithm.beans.Solution;

public class N61 implements Solution {
    @Override
    public void solve() {

    }


    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        while (idx >= 0) {
            if (digits[idx] < 9) {
                digits[idx]++;
                break;
            } else digits[idx] = 0;
            idx--;
        }
        if (idx == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
