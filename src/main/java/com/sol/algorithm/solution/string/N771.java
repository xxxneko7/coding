package com.sol.algorithm.solution.string;

/**
 * 771. 宝石与石头
 */
public class N771 {
    public static void main(String[] args) {
        System.out.println(new N771().numJewelsInStones("aA", "aAAbbb"));
    }

    /**
     * n、m 分别为 jewels 和 stones 的长度
     * <li> 时间复杂度：O(n + m) </li>
     * <li> 空间复杂度：O(1) </li>
     *
     * @param jewels 宝石
     * @param stones 拥有的石头
     * @return 拥有的石头中是宝石的数量
     */
    public int numJewelsInStones(String jewels, String stones) {
        // 'z' - 'A' = 57
        // 用 long 类型的数字 对 jewels 编码
        long key = 0;
        for (char ch : jewels.toCharArray()) {
            key += (1L << (ch - 'A'));
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if ((key & (1L << (ch - 'A'))) != 0) count++;
        }
        return count;
    }
}
