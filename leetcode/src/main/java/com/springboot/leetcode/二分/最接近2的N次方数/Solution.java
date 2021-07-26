package com.springboot.leetcode.二分.最接近2的N次方数;

/**
 * @author: zenan
 * @date: 2021/6/30
 */
public class Solution {

    public static void main(String[] args) {
        int a = 2147483647;
//        System.out.println(new Solution().closest(30));
    }

    public int closest(int a) {
        a |= a >> 1;
        a |= a >> 2;
        a |= a >> 4;
        a |= a >> 8;
        a |= a >> 16;
        return a;
    }
}
