package com.sol.algorithm.solution.string;

/**
 * 28. 实现 strStr()
 */
public class N28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "mississippi";
        System.out.println(new N28().strStr(haystack, needle));
    }

    /**
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置
     *
     * @param haystack 草堆
     * @param needle   针
     * @return needle 在 haystack 中出现的第一个位置
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int b = 131, p = (int) 1e9 + 7;
        long[] preHashOfHaystack = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preHashOfHaystack[i] = (preHashOfHaystack[i - 1] * b + haystack.charAt(i - 1)) % p;
        }
        long hashOfNeedle = 0, powBM = 1;
        for (char ch : needle.toCharArray()) {
            hashOfNeedle = (hashOfNeedle * b + ch) % p;
            powBM = (powBM * b) % p;
        }

        for (int l = 0, r = m; r <= n; l++, r++) {
            long hashOfHaystack = ((preHashOfHaystack[r] - preHashOfHaystack[l] * powBM) % p + p) % p;
            if (hashOfHaystack == hashOfNeedle) return l;
        }
        return -1;
    }
}
