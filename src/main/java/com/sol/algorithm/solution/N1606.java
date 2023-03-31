package com.sol.algorithm.solution;

import java.util.*;

/**
 * 1606. 找到处理最多请求的服务器
 */
public class N1606 {
    public static void main(String[] args) {
        int k;
        int[] arrival, load;
/*        // [1]
        k = 3;
        arrival = new int[]{1, 2, 3, 4, 5};
        load = new int[]{5, 2, 3, 3, 3};
        System.out.println(new N1606().busiestServers(k, arrival, load));

        // [0,1,2]
        k = 3;
        arrival = new int[]{1, 2, 3};
        load = new int[]{10, 12, 11};
        System.out.println(new N1606().busiestServers(k, arrival, load));*/

        // [1]
        k = 3;
        arrival = new int[]{1, 2, 3, 4, 8, 9, 10};
        load = new int[]{5, 2, 10, 3, 1, 2, 2};
        System.out.println(new N1606().busiestServers(k, arrival, load));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            free.offer(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(s -> s[0]));

        int[] requests = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int t = arrival[i];
            // 处理结束的服务器加入空闲队列
            while (!busy.isEmpty() && busy.peek()[0] <= t) {
                int server = busy.poll()[1];
                // 保证得到的是一个不小于 i 的且与 server 同余的数
                free.offer(i + ((server - i) % k + k) % k);
            }
            // 无空闲服务器则抛弃该请求
            if (free.isEmpty()) continue;
            // 分配空闲服务器
            int server = free.poll() % k;
            requests[server]++;
            busy.offer(new int[]{t + load[i], server});
        }

        int max = Arrays.stream(requests).max().getAsInt();
        System.out.println(Arrays.toString(requests));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == max) ans.add(i);
        }
        return ans;
    }
}
