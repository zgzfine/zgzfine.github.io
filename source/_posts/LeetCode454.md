---
title: LeetCode 454. 四数相加 II
date: 2022-10-11 16:03:08
tags:
categories:

- LeetCode
- 哈希表

---

> 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
> * 0 <= i, j, k, l < n
> * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

<!--more-->
>

示例 1：
输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]  
输出：2  
解释：  
两个元组如下：

1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0  
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0    

示例 2：
输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]  
输出：1  

提示：  
n == nums1.length  
n == nums2.length  
n == nums3.length  
n == nums4.length  
1 <= n <= 200  
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228  

```
/**
  * 首先承认是看过来解题思路
  * 如果这道题直接暴力破解，得要四层for循环 时间复杂度O(N^4),明显是超出时间限制
  * 但是这题又不像是两数相加，只需要一层N就可以
  * 所以需要分组，两两一组，分别是两个for循环( O(2*N^2) 也就是等于O(N^2))
  * 由于题目是查询组合，所有，必须要有map纪录，value的次数
  */
 public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
     HashMap<Integer, Integer> map = new HashMap<>();
     for (int a : nums1) {
         for (int b : nums2) {
             int sum = a + b;
             if (map.containsKey(sum)) {
                 map.put(sum, map.get(sum) + 1);//纪录次数，也就是纪录的组合数字
             } else {
                 map.put(sum, 1);
             }
         }
     }
     int result = 0;
     for (int c : nums3) {
         for (int d : nums4) {
             if (map.containsKey(0 - (c + d))) {
                 result = result + map.get(0 - (c + d));
             }
         }
     }
     return result;
 }

```
