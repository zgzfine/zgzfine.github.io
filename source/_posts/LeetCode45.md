---
title: LeetCode 45. 跳跃游戏 II
date: 2022-11-10 11:47:47
tags:
categories:
- LeetCode
- 贪婪算法
---

给你一个非负整数数组nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

<!--more-->
示例 1:

输入: nums = [2,3,1,1,4]  
输出: 2 
解释: 跳到最后一个位置的最小跳跃数是 2。 
从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。 

示例 2:
输入: nums = [2,3,0,1,4] 
输出: 2 

提示:
* 1 <= nums.length <= 10^4
* 0 <= nums[i] <= 1000

```
public class LeetCode45 {

    /**
     * 每次跳跃产生的效益都是最高的，那么就是局部最优解
     */
    public int jump(int[] nums) {
        int step = 0;
        int maxFat = 0;
        int end = 0;//每次的右边界
        for (int i = 0; i < nums.length - 1; i++) {
            maxFat = Math.max(maxFat, i + nums[i]);//在end范围内查找最远的距离
            if (i == end) {//如果到达了最远距离，步数+1，同时更新下一次最远距离
                step++;
                end = maxFat;
            }
        }
        return step;
    }
}

```

