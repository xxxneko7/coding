package com.sol.algorithm.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class N638 {
    /**
     * [9]
     * [[1,10],[2,2]]
     * [3]
     * <p>
     * 11
     */
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(9);
        String s = "[[1,10],[2,2]]";
        List<List<Integer>> special = Arrays.stream(s.substring(2, s.length() - 2).split("],\\[")).map(sub -> Arrays.stream(sub.split(",")).map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
        List<Integer> needs = Arrays.asList(3);
        N638 solution = new N638();
        System.out.println(solution.shoppingOffers(price, special, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.minPrice = Integer.MAX_VALUE;
        int n = needs.size();
        Iterator<List<Integer>> iterator = special.iterator();
        while (iterator.hasNext()) {
            List<Integer> pack = iterator.next();
            if (IntStream.range(0, n).anyMatch(i -> pack.get(i) > needs.get(i))) {
                iterator.remove();
                continue;
            }
            if (IntStream.range(0, n).map(i -> pack.get(i) * price.get(i)).sum() <= pack.get(pack.size() - 1)) {
                iterator.remove();
            }
        }
        backtrack(price, special, needs, 0);
        return minPrice;
    }

    int minPrice;

    private void backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int totalPrice) {
        boolean isUseSpecial = false;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> pack = special.get(i);
            int j = 0;
            List<Integer> newNeeds = new ArrayList<>();
            for (; j < needs.size(); j++) {
                if (needs.get(j) < pack.get(j)) {
                    break;
                }
                newNeeds.add(needs.get(j) - pack.get(j));
            }
            // use special[i]
            if (j == needs.size()) {
                backtrack(price, special, newNeeds, totalPrice + pack.get(pack.size() - 1));
                isUseSpecial = true;
            }
        }
        if (!isUseSpecial) {
            totalPrice += IntStream.range(0, needs.size()).map(i -> needs.get(i) * price.get(i)).sum();
            minPrice = Math.min(minPrice, totalPrice);
        }
    }
}
