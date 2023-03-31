package com.sol.algorithm.solution;

/**
 * 420. 强密码检验器
 */
public class N420 {
    public static void main(String[] args) {
        // 2
        System.out.println(new N420().strongPasswordChecker("123a"));
    }
    public int strongPasswordChecker(String password) {
        int n = password.length();
        password = password + " ";
        char[] chars = password.toCharArray();

        int lowercase = 0, uppercase = 0, digit = 0;
        for (char c : chars) {
            if (Character.isLowerCase(c)) lowercase = 1;
            else if (Character.isUpperCase(c)) uppercase = 1;
            else if (Character.isDigit(c)) digit = 1;
        }
        int type = 3 - (lowercase + uppercase + digit);

        if (n < 6) return Math.max(6 - n, type);
        if (n <= 20) return getNumOfOptionsForEffectiveLen(chars, type);
        return getNumOfOptionsForExceededLen(chars, type, n - 20);
    }

    private int getNumOfOptionsForExceededLen(char[] chars, int type, int remove) {
        int replace = 0, rm1 = 0, redundancy = remove;
        for (int i = 0, j = i; i < chars.length - 1;) {
            while (chars[i] == chars[j]) j++;
            int count = j - i;
            if (redundancy > 0 && count >= 3) {
                int rm = count % 3;
                if (rm == 0) {
                    replace--;
                    redundancy--;
                } else if (rm == 1) rm1++;
            }
            replace += count / 3;
            i = j;
        }

        int t = Math.min(rm1 * 2, redundancy);
        replace -= t / 2;
        redundancy -= t;

        t = Math.min(redundancy / 3, replace);
        replace -= t;

        return remove + Math.max(replace, type);
    }

    private int getNumOfOptionsForEffectiveLen(char[] chars, int type) {
        int replace = 0;
        for (int i = 0, j = i; i < chars.length - 1; ) {
            while (chars[i] == chars[j]) j++;
            int count = j - i;
            if (count >= 3) replace += count / 3;
            i = j;
        }
        return Math.max(replace, type);
    }
}
