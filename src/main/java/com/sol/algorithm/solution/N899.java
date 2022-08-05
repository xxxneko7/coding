package com.sol.algorithm.solution;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class N899 {
    public static void main(String[] args) {
        System.out.println(new N899().orderlyQueue("cba", 1));
    }

    /***
     * 给定一个字符串 s 和一个整数 k  。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
     *
     * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串  。
     */
    public String orderlyQueue(String s, int k) {
        int l = s.length();
        if (l <= k) {
            return s.chars().sorted().boxed().map(String::valueOf).collect(Collectors.joining());
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[0]));
        StringBuilder sb = new StringBuilder();
        Set<Integer> mark = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            sb.append(q[0]);
            mark.add(q[1]);
        }
        char[] chars = s.toCharArray();
        PriorityQueue<Character> min = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if (mark.contains(i)) continue;
            min.offer(chars[i]);
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = k; i < l; i++) {
            if (mark.contains(i)||min.isEmpty()) continue;
            Character ch = min.poll();
            sb1.append(ch);
        }
        return sb.toString();
    }

    // 1 1 2 | j a a
    //  a 1 b d i 2 j a 1 c d
}
