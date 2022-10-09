---
title: LeetCode 35. 搜索插入位置
date: 2022-10-04 00:12:49
tags:
---

> 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。  
> 请必须使用时间复杂度为 O(log n) 的算法。

<!--more-->

> 输入: nums = [1,3,5,6], target = 5  
> 输出: 2
>
> 输入: nums = [1,3,5,6], target = 2  
> 输出: 1
>
> 输入: nums = [1,3,5,6], target = 7  
> 输出: 4


~~~
/**
 * 由于题目要求 O(log n),所以要考虑到 二分法，递归等
 *
 * @param nums 数组
 * @param target 目标值
 * @return 下标
 */
public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int l = 0;
    int r = nums.length - 1;
    //在 l跟r的闭区间内
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > target) {
            r = mid - 1;
        } else if (nums[mid] < target) {
            l = mid + 1;
        } else {
            //如果target小于数组的第一个值，那么插入后的位置就是0
            //基于上述的原因，这里的mid会等于l，也就是等于0
            return mid;
        }
    }
    return r + 1;
}

~~~