package com.sol.algorithm.solution.map;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * // 截取第一个'.'之后的字符串作为新的【domain】，找不到时退出循环
 * int idxOfFirstDot = domain.indexOf('.');
 * if (idxOfFirstDot < 0) {
 * break;
 * } else {
 * domain = domain.substring(idxOfFirstDot + 1);
 * }
 * 811. 子域名访问计数
 */
public class N811 {
    public static void main(String[] args) {
        System.out.println(new N811().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    /**
     * n为【cpdomains】的长度，这里假设每个 cpdomain 的长度都是常数级
     * <li> 时间复杂度：O(n) </li>
     * <li> 空间复杂度：O(n) </li>
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        // 通过【HashMap】保存【域名到访问次数】的映射，统计域名的访问次数
        Map<String, Integer> domainToRep = new HashMap<>(cpdomains.length * 2);

        for (String cpdomain : cpdomains) {
            char[] domain = cpdomain.toCharArray();
            int idx = 0, n = domain.length;
            StringBuilder sb = new StringBuilder();
            while (idx < n && domain[idx] != ' ') {
                sb.append(domain[idx++]);
            }
            int rep = Integer.parseInt(sb.toString());
            while (idx++ < n) {
                String subdomain = new String(domain, idx, domain.length - idx);
                domainToRep.put(subdomain, rep + domainToRep.getOrDefault(subdomain, 0));
                while (idx < n && domain[idx] != '.') idx++;
            }
/*            String[] repAndDomain = cpdomain.split(" ");
            int rep = Integer.parseInt(repAndDomain[0]);
            char[] domain = repAndDomain[1].toCharArray();
            for (int i = 0; i < domain.length; i++) {
                String subdomain = new String(domain, i, domain.length - i);
                domainToRep.put(subdomain, rep + domainToRep.getOrDefault(subdomain, 0));
                while (i < domain.length && domain[i] != '.') i++;
            }*/
        }
        // 将结果转化为字符串数组
        List<String> res = new ArrayList<>();
        domainToRep.forEach((domain, numOfVisits) -> res.add(numOfVisits + " " + domain));
        return res;
    }
}
