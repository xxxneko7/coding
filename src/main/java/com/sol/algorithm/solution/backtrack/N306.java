package com.sol.algorithm.solution.backtrack;

/**
 * <a href="https://leetcode.cn/problems/additive-number/">306. 累加数</a>
 * 只需要确定前两个数字，然后验证后续数字
 */
public class N306 {
    public static void main(String[] args) {
        N306 solution = new N306();
        System.out.println(solution.isAdditiveNumber("112358"));
    }

    public boolean isAdditiveNumber(String num) {
        this.isAddNum = false;
        this.num = num;
        this.n = num.length();
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondEnd != secondStart) {
                    break;
                }
                if (valid(secondStart, secondEnd)) {
                    return true;
                }
            }
        }
        return isAddNum;
    }

    boolean isAddNum;
    int n;
    String num;

    private boolean valid(int secondStart, int secondEnd) {
        int firstStart = 0, firstEnd = secondEnd - 1;
        while (secondEnd < n) {
            String third = stringAdd(firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    private String stringAdd(int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuilder third = new StringBuilder();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += num.charAt(firstEnd) - '0';
                firstEnd--;
            }
            if (secondEnd >= secondStart) {
                cur += num.charAt(secondEnd) - '0';
                secondEnd--;
            }
            carry = cur / 10;
            cur = cur % 10;
            third.append(cur);
        }
        third.reverse();
        return third.toString();
    }

}
