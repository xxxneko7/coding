package com.sol.algorithm.solution.tree;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 136. 邻值查找
 */
public class AC136 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(scan.next());
        }

        scan.close();

        SortedSet<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.add(sequence[0]);
        for (int i = 1; i < n; i++) {
            int max = sortedSet.first();
            System.out.println(Math.abs(sequence[i] - max) + " " + max);
            sortedSet.add(max);
        }
    }
}
