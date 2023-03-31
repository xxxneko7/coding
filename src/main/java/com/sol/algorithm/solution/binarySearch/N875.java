package com.sol.algorithm.solution.binarySearch;

/**
 * 875. 爱吃香蕉的珂珂
 */
public class N875 {
    public static void main(String[] args) {
        System.out.println(new N875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    /**
     * 返回在时限 h 内吃完所有香蕉所需要的最小速度 k（根/小时），每小时只能选择某一堆香蕉，如果香蕉数小于 k，这一小时也不会选择新的香蕉堆
     *
     * @param piles 第 i 堆中有 piles[i] 根香蕉
     * @param h     时限
     * @return 每小时吃掉香蕉的最少根数
     */
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        // 速度至少是 1，上限为 max(piles)，直接使用 piles[i] 允许的最大值(10^9) 避免计算
        int minSpeed = 1, upper = (int)1e9;
        while (minSpeed < upper) {
            int speed = (minSpeed + upper) / 2;
            int time = calTime(speed);
            if (time <= h) {
                upper = speed;
            } else {
                minSpeed = speed + 1;
            }
        }
        return minSpeed;
    }

    /**
     * 计算吃完所有香蕉需要的时间
     *
     * @param speed 每小时吃掉香蕉的根数
     * @return 时间（小时）
     */
    private int calTime(int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }

    int[] piles;
}
