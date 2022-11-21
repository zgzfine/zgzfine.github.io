---
title: LeetCode 35. 搜索插入位置
date: 2022-09-28 00:01:25
type: 算法
tags: LeetCode
categories:
- LeetCode
- 数组
---


> 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。  
> 请必须使用时间复杂度为 O(log n) 的算法。

<!--more-->

> 示例 1:   
> 输入: nums = [1,3,5,6], target = 5  
> 输出: 2
>
> 示例 2:   
> 输入: nums = [1,3,5,6], target = 2  
> 输出: 1
>
> 示例 3:  
> 输入: nums = [1,3,5,6], target = 7  
> 输出: 4
>
> 提示:  
> 1 <= nums.length <= 104  
> -104 <= nums[i] <= 104  
> nums 为无重复元素的升序排列数组  
> -104 <= target <= 104

## 思路

---
根据题意，这是一个有序的数组，所以一般对于查找数据，需要立马条件反射到使用二分查找，因为二分查找的时间复杂度为：**O(logN)** ,满足题意

对于一个数插入原数组，需要满足以下条件

* 目标值在数组所有元素之前
* 目标值等于数组中某一个元素
* 目标值插入数组中的位置
* 目标值在数组所有元素之后

## 程序

```
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

```