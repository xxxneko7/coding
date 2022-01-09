package com.sol.algorithm.solution.map;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 */
public class N811 {
    public static void main(String[] args) {
        System.out.println(new N811().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    /**
     * n为【cpdomains】的长度，这里假设每个 cpdomain 的长度都是常数级 <br>
     * - 时间复杂度：O(n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param cpdomains 计数配对域名数组
     * @return 每个子域名的 计数配对域名
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        // 通过【HashMap】保存【域名到访问次数】的映射，统计域名的访问次数
        Map<String, Integer> domainToRep = new HashMap<>(cpdomains.length * 2);

        for (String cpdomain : cpdomains) {
            char[] domain = cpdomain.toCharArray();
            int idx = cpdomain.indexOf(' '), n = domain.length;
            // ' '之前的字符串解析为访问次数【rep】
            StringBuilder sb = new StringBuilder();
            while (idx < n && domain[idx] != ' ') {
                sb.append(domain[idx++]);
            }
            int rep = Integer.parseInt(sb.toString());
            // domain[idx]为' '或'.'，因此截取【idx】的下一个位置到【domain】末尾的字符作为【subdomain】
            while (idx++ < n) {
                String subdomain = new String(domain, idx, domain.length - idx);
                domainToRep.put(subdomain, rep + domainToRep.getOrDefault(subdomain, 0));
                // 【idx】指向下一个'.'
                while (idx < n && domain[idx] != '.') {
                    idx++;
                }
            }
        }
        // 将结果转化为字符串数组
        List<String> res = new ArrayList<>();
        domainToRep.forEach((domain, numOfVisits) -> res.add(numOfVisits + " " + domain));
        return res;
    }
}
