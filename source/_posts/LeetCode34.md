---
title: LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
date: 2022-10-03 00:54:54
tags:
---


> 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
> 如果数组中不存在目标值 target，返回[-1, -1]。  
> 你必须设计并实现时间复杂度为O(log n) 的算法解决此问题。  

<!--more-->

> 输入：nums = [5,7,7,8,8,10], target = 8  
> 输出：[3,4]  
>   
> 输入：nums = [5,7,7,8,8,10], target = 6    
> 输出：[-1,-1]
> 
> 输入：nums = [], target = 0   
> 输出：[-1,-1]
 
~~~
/**
 * 这道题要用二分法找到左边的开始位置，以及右边的结束位置
 * 同时需要考虑，target不在数组中
 * <p>
 * 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
 * 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
 * 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
 */
public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
        return new int[]{-1, -1};
    }
    int rithtIndex = rithtIndex(nums, target);
    int leftIndex = leftIndex(nums, target);
    if (rithtIndex == -2 || leftIndex == -2) {
        return new int[]{-1, -1};
    }
    if (rithtIndex - leftIndex > 1) return new int[]{leftIndex + 1, rithtIndex - 1};
    return new int[]{-1, -1};
}

public int rithtIndex(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int rithtIndex = -2;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > target) {//一直缩小右边界
            r = mid - 1;
        } else {
            l = mid + 1;
            rithtIndex = l;
        }
    }
    return rithtIndex;
}

public int leftIndex(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int leftIndex = -2;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] < target) {//一直缩小右边界
            l = mid + 1;
        } else {
            r = mid - 1;
            leftIndex = r;
        }
    }
    return leftIndex;
}

~~~

 
