package com.springboot.leetcode.树.二叉树层序遍历;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // result
        List<List<Integer>> parentList = new ArrayList<>();
        // queue
        Queue<Queue<TreeNode>> parentQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentQueue.add(queue);

        while (!parentQueue.isEmpty()) {
            Queue<TreeNode> childQueue = new LinkedList<>();
            List<Integer> childList = new ArrayList<>();

            queue = parentQueue.poll();
            while(!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
//                    childList.add(null);
                }else {
                    childList.add(treeNode.val);
                    childQueue.add(treeNode.left);
                    childQueue.add(treeNode.right);
                }
            }
            if (!childList.isEmpty()) {
                parentList.add(childList);
            }

            if (!childQueue.isEmpty()) {
                parentQueue.add(childQueue);
            }
        }
        return parentList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        List<List<Integer>> ll = new Solution().levelOrder(null);
        System.out.println(ll);
    }
}
