package com.springboot.leetcode.树.二叉树的前序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> arr = new ArrayList<>();
//        preorder(arr, root);
//        return arr;
        return preorder(root);
    }

    /**
     * 递归遍历
     * @param arr list
     * @param root tree node
     */
    private void preorder(List<Integer> arr, TreeNode root) {
        if (root == null) return;
        arr.add(root.val);
        preorder(arr, root.left);
        preorder(arr, root.right);
    }

    /**
     * 非递归实现
     * @param root tree node
     * @return list
     */
    private List<Integer> preorder(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node;

        deque.push(root);
        while (!deque.isEmpty()) {
            node = deque.pop();
            arr.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return arr;
    }

}
