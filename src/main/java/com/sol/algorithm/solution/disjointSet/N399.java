package com.sol.algorithm.solution.disjointSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 除法求值
 */
public class N399 {
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.stream("x1,x2;x2,x3;x3,x4;x4,x5".split(";")).map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).collect(Collectors.toList());
        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = Arrays.stream("x1,x5;x5,x2;x2,x4;x2,x2;x2,x9;x9,x9".split(";")).map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println(Arrays.toString(new N399().calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, Integer> variables = new HashMap<>(n);
        int index = 0;
        for (List<String> equation : equations) {
            String a = equation.get(0);
            if (!variables.containsKey(a)) variables.put(a, index++);
            String b = equation.get(1);
            if (!variables.containsKey(b)) variables.put(b, index++);
        }

        int m = variables.size();
        this.weight = new double[m];
        this.fa = new int[m];
        for (int i = 0; i < m; i++) {
            fa[i] = i;
        }
        Arrays.fill(weight, 1.0);

        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            int a = variables.get(equation.get(0)), b = variables.get(equation.get(1));
            union(a, b, values[i]);
        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            List<String> query = queries.get(i);
            if (!variables.containsKey(query.get(0)) || !variables.containsKey(query.get(1))) {
                res[i] = -1;
                continue;
            }
            int a = variables.get(query.get(0)), b = variables.get(queries.get(i).get(1));
            System.out.println(Arrays.toString(fa));
            System.out.println(Arrays.toString(weight));
            System.out.println();
            int fa = find(a), fb = find(b);
            if (fa == fb) res[i] = weight[a] / weight[b];
            else res[i] = -1;
        }

        return res;
    }

    double[] weight;
    int[] fa;

    private void union(int x, int y, double value) {
        int fx = find(x);
        int fy = find(y);
        fa[fx] = fy;
        weight[fx] = value * weight[y] / weight[x];
    }

    private int find(int x) {
        if (x == fa[x]) return x;
        int father = find(fa[x]);
        weight[x] = weight[x] * weight[fa[x]];
        fa[x] = father;
        return fa[x];
    }


}