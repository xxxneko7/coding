package com.sol.algorithm.solution.array;

/**
 * 66. 加一
 */
public class N66 {
    /**
     * n为【digits】数组的长度
     * <li>时间复杂度：O(n)</li>
     * <li>空间复杂度：O(1)</li>
     */
    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        while (idx >= 0) {
            // 无进位
            if (digits[idx] < 9) {
                digits[idx]++;
                break;
            } else {
                digits[idx] = 0;
            }
            idx--;
        }
        // 超出数组范围时，使用新的数组，首位为1，其他位为0
        if (idx == -1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
