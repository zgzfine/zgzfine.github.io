---
title: LeetCode 1. 两数之和
date: 2022-10-11 15:20:29
tags:
categories:
- LeetCode
- 哈希表
---

> 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。  

<!--more-->

> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
>  你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9  
输出：[0,1]  
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。  


示例 2：  
输入：nums = [3,2,4], target = 6  
输出：[1,2]  

示例 3：  
输入：nums = [3,3], target = 6  
输出：[0,1]  


```
/**
 * 假如使用暴力算法，那么这个题的时间复杂度是 O(N^2),所以需要找到更加快的方法，比如有没有可能O(N)或者O(logN)?
 * 首先想到 哈希表， 映射的方法，时间复杂度是O(N),空间复杂度O(N)
 */
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int a = target - nums[i];
        if (map.containsKey(a)) {
            return new int[]{map.get(a), i};
        }
        map.put(nums[i], i);
    }
    return new int[2];
}

```
