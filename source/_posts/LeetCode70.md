---
title: LeetCode 70. 爬楼梯
date: 2022-11-28 16:52:12
tags:
categories:
- LeetCode
- 动态规划
---

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
<!--more-->

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
   示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶


提示：

1 <= n <= 45


```
/**
 * 70. 爬楼梯
 */
public class LeetCode70 {

    /**
     * 这是一道动态规划的题目，需要确立动态规划式子
     * 每次只能走一步或者两步，那么
     * dp[n]只能由dp[n-1]或者dp[n-2]通过走一步或者两步到达，那么
     * dp[n] = dp[n-1]+dp[n-2]
     * 第二部，确立好初始值
     * dp[1] = 1,dp[2] = 1
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}


```
