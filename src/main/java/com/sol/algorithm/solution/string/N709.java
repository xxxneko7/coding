package com.sol.algorithm.solution.string;

/**
 * 709. 转换成小写字母
 */
public class N709 {
    /**
     * n 为字符串的长度
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     *
     * @param s 字符串
     * @return 大写字母转换成相同的小写字母
     */
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') chars[i] = (char) (chars[i] - 'A' + 'a');
        }
        return new String(chars);
    }
}
