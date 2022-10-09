---
title: LeetCode 209. 长度最小的子数组
date: 2022-10-06 16:28:29
tags: LeetCode
categories:
- LeetCode
- 数组
---

> 给定一个含有n个正整数的数组和一个正整数 target 。  
> 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。  
>

<!--more-->

> 输入：target = 7, nums = [2,3,1,2,4,3]  
> 输出：2   
> 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
> 
> 输入：target = 4, nums = [1,4,4]  
> 输出：1
> 
> 输入：target = 11, nums = [1,1,1,1,1,1,1,1]  
> 输出：0
> 

~~~
/**
 * 1、最应该想到的是暴力破解，一层外循环遍历所有字符，一层内循环遍历得到的子数组，明显时间复杂度 O（n^2）
 * 2、滑动窗口，其实就是双指针，在指针范围内的子数组，满足target，并不断的调节子左右指针，额外的变量纪录窗口的最小值
 */
public int minSubArrayLen(int target, int[] nums) {
    int l = 0;
    int r = 0;
    int sum = 0;//窗口的值
    int min = Integer.MAX_VALUE;
    //右指针到达数组结尾即结束
    while (r < nums.length) {
        sum = sum + nums[r];
        //外循环 r指针不断的往右增加值
        while (sum >= target) {
            //内循环 l指针不断的往右缩减
            min = Math.min(r - l + 1, min);
            sum = sum - nums[l++];
        }
        r++;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
}
~~~