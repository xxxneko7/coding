package com.sol.algorithm.solution.binarySearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class N1011 {
    public static void main(String[] args) {
        System.out.println(new N1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    /**
     * 将 n 个包裹在 days 天内送往目的地所需的最低运载能力
     * <p>
     * - 时间复杂度：O(n * log(sum(weights)))， log(sum(weights)) <br>
     * - 空间复杂度：1 <br>
     *
     * @param weights 包裹的重量
     * @param days    天数限制
     * @return 最低运载能力
     */
    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        int sum = 0, max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        int minLoad = max;
        while (minLoad < sum) {
            // 二分查找
            int load = (minLoad + sum) / 2;
            if (calDaysRequired(load) > days) {
                minLoad = load + 1;
            } else {
                sum = load;
            }
        }
        return minLoad;
    }

    /**
     * 计算 load 负载下运送包裹所需的天数
     *
     * @param load 负载
     * @return 所需天数
     */
    private int calDaysRequired(int load) {
        int daysRequired = 1;
        int curWeight = 0;
        for (int weight : weights) {
            curWeight += weight;
            if (curWeight > load) {
                curWeight = weight;
                daysRequired++;
            }
        }
        return daysRequired;
    }

    /**
     * 包裹重量
     */
    private int[] weights;
}
