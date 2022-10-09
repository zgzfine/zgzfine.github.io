---
title: LeetCode 977. 有序数组的平方
date: 2022-10-06 16:42:59
tags: LeetCode
categories:
- LeetCode
- 数组
---


> 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

<!--more-->

> 输入：nums = [-4,-1,0,3,10]  
> 输出：[0,1,9,16,100]  
> 解释：平方后，数组变为 [16,1,0,9,100]  
> 排序后，数组变为 [0,1,9,16,100]
>

~~~
/**
 * nums = [-4,-1,0,3,10]
 * 如果使用暴力解法，先一轮循环将所有的数值乘方后再快速排序，时间复杂度应该是 O（nlogn）
 * 根据题意分析，实际上可能数组有负数，所以，有可能乘方之后，最小的值在数组中间
 * 所有需要考虑使用双指针法，左右指针相遇，程序结束
 */
public int[] sortedSquares(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int[] ret = new int[nums.length];
    int k = nums.length - 1;
    while (l <= r) {
        if ((long) nums[l] * nums[l] <= (long) nums[r] * nums[r]) {
            ret[k--] = nums[r] * nums[r];
            --r;
        } else {
            ret[k--] = nums[l] * nums[l];
            ++l;
        }
    }
    return ret;
}
~~~