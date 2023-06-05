package com.sol.algorithm.solution.stack;

import java.util.ArrayList;
import java.util.List;

public class N77 {
    public static void main(String[] args) {
        N77 solution = new N77();
        List<List<Integer>> res = solution.combine(4, 2);
        for (List<Integer> ans : res) {
            System.out.println(ans);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            temp.add(i);
        }
        temp.add(n + 1);
        int i = 0;
        while (i < k) {
            res.add(new ArrayList<>(temp.subList(0, k)));
            i = 0;
            while (i < k && temp.get(i) + 1 == temp.get(i + 1)) {
                temp.set(i, i + 1);
                i++;
            }
            temp.set(i, temp.get(i) + 1);
        }
        return res;
    }
}
