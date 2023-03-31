package com.sol.algorithm.solution.string;

/**
 * 394. 字符串解码
 */
public class N394 {
    public static void main(String[] args) {
        String s;

        s = "3[a]2[bc]";
        // "aaabcbc"
        System.out.println("aaabcbc".equals(new N394().decodeString(s)));

        s = "3[a2[c]]";
        // "accaccacc"
        System.out.println("accaccacc".equals(new N394().decodeString(s)));

        s = "2[abc]3[cd]ef";
        // "abcabccdcdcdef"
        System.out.println("abcabccdcdcdef".equals(new N394().decodeString(s)));

        s = "abc3[cd]xyz";
        // "abccdcdcdxyz"
        System.out.println("abccdcdcdxyz".equals(new N394().decodeString(s)));

        s = "10[a]";
        // "aaaaaaaaaa"
        System.out.println("aaaaaaaaaa".equals(new N394().decodeString(s)));
    }

    public String decodeString(String s) {
        return decodeString(s.toCharArray());
    }

    private String decodeString(char[] chars) {
        StringBuilder decodeStr = new StringBuilder();
        String num = "";
        while (idx < chars.length) {
            char ch = chars[idx++];
            if (Character.isDigit(ch)) {
                num += ch;
            } else if (ch == '[') {
                int k = Integer.parseInt(num);
                num = "";
                String encodeStr = decodeString(chars);
                while (k-- > 0)
                    decodeStr.append(encodeStr);
            } else if (ch == ']') {
                break;
            } else {
                decodeStr.append(ch);
            }

        }
        return decodeStr.toString();
    }

    int idx = 0;
}
