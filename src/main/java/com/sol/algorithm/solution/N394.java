package com.sol.algorithm.solution;

/**
 * 394. 字符串解码
 */
public class N394 {
    public static void main(String[] args) {
        String s;

        s = "3[a]2[bc]";
        // "aaabcbc"
        System.out.println(new N394().decodeString(s));

        s = "3[a2[c]]";
        // "accaccacc"
        System.out.println(new N394().decodeString(s));

        s = "2[abc]3[cd]ef";
        // "abcabccdcdcdef"
        System.out.println(new N394().decodeString(s));

        s = "abc3[cd]xyz";
        // "abccdcdcdxyz"
        System.out.println(new N394().decodeString(s));
    }

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder decodeStr = new StringBuilder();
        return decodeStr.toString();
    }

    public int encodeString(char[] chars, int l, int k) {
        StringBuilder encodeStr = new StringBuilder();
        for (int i = l + 1; i < chars.length; ) {
            char c = chars[i];
            if (Character.isDigit(c))
            else if (c == '[') encodeStr.append(encodeString(chars, i + 1));
            else if (c == ']') {
                while (k-- > 0)
                    decodeStr.append(encodeStr);
                encodeStr = new StringBuilder();
            } else
        }
        return encodeStr.toString();
    }
}
