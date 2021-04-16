package com.springboot.leetcode.数组.在排序数组中查找数字I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
class Solution {
    /**
     * 二分(Java 容器)
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int count = 0;
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int length;
        while ((length = arr.size()) > 0) {
            if (arr.get(length/2) > target) {
                arr = arr.subList(0, length/2);
                continue;
            }
            if (arr.get(length/2) < target) {
                arr = arr.subList(length/2+1, length);
                continue;
            }
            for (int i = length/2; i < length; i++) {
                if (arr.get(i) == target) {
                    count++;
                }else{
                    break;
                }
            }
            for (int i = length/2 - 1; i > -1; i--) {
                if (arr.get(i) == target) {
                    count++;
                }else {
                    break;
                }
            }
            break;
        }
        return count;
    }

    /**
     * 二分(数组)
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int count = 0;
        while (nums.length > 0) {
            if (nums[nums.length/2] > target) {
                nums = Arrays.copyOfRange(nums, 0, nums.length/2);
                continue;
            }
            if (nums[nums.length/2] < target) {
                nums = Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length);
                continue;
            }
            for (int i = nums.length/2; i < nums.length; i++) {
                if (nums[i] == target) {
                    count ++;
                }else{
                    break;
                }
            }
            for (int i = nums.length/2 - 1; i > -1; i--) {
                if (nums[i] == target) {
                    count ++;
                }else{
                    break;
                }
            }
            break;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
