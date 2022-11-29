---
title: LeetCode 746. 使用最小花费爬楼梯
date: 2022-11-29 11:47:55
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
 * 746. 使用最小花费爬楼梯
 */
public class LeetCode746 {

    /**
     * 同样是动态规划，以及贪心
     * 每次赋值都是对比上一个值加上花费，以及上上值加上花费，那个小取那个
     * 需要注意好区间边界的问题
     * dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length - 1];
    }
}

```
