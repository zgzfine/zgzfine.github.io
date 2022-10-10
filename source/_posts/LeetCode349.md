---
title: LeetCode 349. 两个数组的交集
date: 2022-10-10 16:08:03
tags:
categories:
- LeetCode
- 哈希表
---

> 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
> 

<!--more-->
> 输入：nums1 = [1,2,2,1], nums2 = [2,2]  
> 输出：[2]
> 
> 
> 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]  
> 输出：[9,4]  
> 解释：[4,9] 也是可通过的  
> 
```
/**
 * 题目中，输出结果是唯一的，所以自然应该想要哈希中的 set（去重）
 */
public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) {
        return new int[0];
    }
    Set<Integer> a = new HashSet<>();
    Set<Integer> result = new HashSet<>();
    for (int i : nums1) {
        a.add(i);
    }
    for (int i : nums2) {
        //如果a 包含i 则放到结果集
        if (a.contains(i)) {
            result.add(i);
        }
    }
    return result.stream().mapToInt(x -> x).toArray();
}

```