package com.sol.algorithm.solution.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 00111 [1, 2, 3]
 * 01011 [1, 2, 4]
 * 01101 [1, 3, 4]
 * 01110 [2, 3, 4]
 * 10011 [1, 2, 5]
 * 10101 [1, 3, 5]
 * 10110 [2, 3, 5]
 * 11001 [1, 4, 5]
 * 11010 [2, 4, 5]
 * 11100 [3, 4, 5]
 */
public class N77 {
    public static void main(String[] args) {
        List<List<Integer>> res = new N77().combine(5, 3);
        for (List<Integer> ans : res) {
            System.out.println(ans);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(i + 1);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            res.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                j++;
            }
            temp.set(j, temp.get(j) + 1);
        }
        return res;
    }
}
