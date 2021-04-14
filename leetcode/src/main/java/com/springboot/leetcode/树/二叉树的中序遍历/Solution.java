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
//        递归
//        inorder(list, root);

//        非递归
        nonInorder(list, root);
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
    private void nonInorder(List<Integer> arr, TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> treeDeque = new LinkedList<>();
        push(treeDeque, node);

        while (!treeDeque.isEmpty()) {
            TreeNode treeNode = treeDeque.pop();
            arr.add(treeNode.val);
            if (treeNode.right != null) {
                push(treeDeque, treeNode.right);
            }
        }
    }

    private void push(Deque<TreeNode> deque, TreeNode treeNode) {
        if (treeNode == null) return;
        deque.push(treeNode);
        while (treeNode.left != null) {
            deque.push(treeNode.left);
            treeNode = treeNode.left;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        List<Integer> l = new Solution().inorderTraversal(node);
        System.out.println(l);
    }
}