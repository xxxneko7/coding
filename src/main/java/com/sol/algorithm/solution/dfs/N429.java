package com.sol.algorithm.solution.dfs;

import com.sol.algorithm.structure.Node;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 */
public class N429 {
    /**
     * N 叉树层序遍历
     * <p>
     * n 为树的节点数量 <br>
     * - 时间复杂度：O(n) <br>
     * - 空间复杂度：O(n) <br>
     *
     * @param root N 叉树树根
     * @return 层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> seq = new ArrayList<>();
        if (Objects.isNull(root)) return seq;

        List<Node> curLevel = Collections.singletonList(root);

        while (!curLevel.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            List<Integer> curVals = new ArrayList<>();
            for (Node node : curLevel) {
                curVals.add(node.val);
                nextLevel.addAll(node.children);
            }
            seq.add(curVals);
            curLevel = nextLevel;
        }
        return seq;
    }
}
