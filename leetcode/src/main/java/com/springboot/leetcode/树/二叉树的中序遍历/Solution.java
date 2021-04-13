package com.springboot.leetcode.树.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zenan
 * @date: 2021/4/13
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list;
    }

    /**
     * 递归实现 easy
     * @param arr list
     * @param node tree node
     */
    private void inorder(List<Integer> arr, TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(arr, node.left);
        arr.add(node.val);
        inorder(arr, node.right);
    }

    /**
     * 非递归实现
     * @param arr list
     * @param node tree node
     * @return list
     */
    private List<Integer> nonInorder(List<Integer> arr, TreeNode node) {
        if (node == null) {
            return arr;
        }
        Deque<TreeNode> treeDeque = new LinkedList<>();
        Deque<Integer> valueDeque = new LinkedList<>();
        treeDeque.push(node);

        while (node.left != null) {
            treeDeque.push(node.left);
            node = node.left;
        }

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        List<Integer> l = new Solution().inorderTraversal(node);
        System.out.println(l);
    }
}