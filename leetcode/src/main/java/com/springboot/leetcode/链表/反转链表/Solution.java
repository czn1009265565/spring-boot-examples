package com.springboot.leetcode.链表.反转链表;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode node;
        slow.next = null;
        while (fast != null) {
            node = fast.next;

            fast.next = slow;
            slow = fast;
            fast = node;
        }
        return slow;
    }
}
