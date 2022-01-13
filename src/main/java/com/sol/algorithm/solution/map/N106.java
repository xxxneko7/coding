package com.sol.algorithm.solution.map;


import com.sol.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class N106 {

    public interface Solution {
        /**
         * 构造二叉树
         *
         * @param inorder   中序遍历
         * @param postorder 后序遍历
         * @return 二叉树根节点
         */
        TreeNode buildTree(int[] inorder, int[] postorder);
    }

    public class Recursion implements Solution {
        /**
         * 后序遍历
         */
        private int[] postorder;

        /**
         * 值到中序遍历下标的映射
         */
        private Map<Integer, Integer> valToInorderIdx;

        /**
         * 后序遍历下标
         */
        private int postorderIdx;

        /**
         * n为节点数量 <br>
         * - 时间复杂度：O(n) <br>
         * - 空间复杂度：O(n) <br>
         */
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            this.postorder = postorder;
            this.valToInorderIdx = new HashMap<>(n + 1, 1);
            for (int i = 0; i < n; i++) {
                valToInorderIdx.put(inorder[i], i);
            }
            this.postorderIdx = n - 1;
            return buildSubtree(0, n - 1);
        }

        /**
         * 构造子树
         *
         * @param left  左边界
         * @param right 右边界
         * @return inorder[left, right] 区间内的根节点
         */
        private TreeNode buildSubtree(int left, int right) {
            if (left > right) {
                return null;
            }
            int val = postorder[postorderIdx--];
            TreeNode root = new TreeNode(val);
            int inorderIdx = valToInorderIdx.get(val);
            root.left = buildSubtree(left, inorderIdx - 1);
            root.right = buildSubtree(inorderIdx + 1, right);
            return root;
        }
    }


    public class Iteration implements Solution {
        /**
         * n为节点数量 <br>
         * - 时间复杂度：O(n) <br>
         * - 空间复杂度：O(n) <br>
         */
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            TreeNode root = new TreeNode(postorder[n - 1]);

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int inorderIdx = n - 1;
            for (int postorderIdx = n - 2; postorderIdx >= 0; postorderIdx--) {
                TreeNode curNode = stack.peek();
                int postorderVal = postorder[postorderIdx];
                // 右节点
                if (curNode.val != inorder[inorderIdx]) {
                    curNode.right = new TreeNode(postorderVal);
                    stack.push(curNode.right);
                    continue;
                }
                // 左节点
                while(stack.isEmpty()||){

                }
            }
            return root;
        }
    }
}
