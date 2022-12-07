---
title: LeetCode 343. 整数拆分
date: 2022-12-07 11:05:51
tags:
categories:

- LeetCode
- 动态规划

---

给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

返回 你可以获得的最大乘积 。

<!--more-->

示例 1:

输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

示例2:

输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。

提示:

* 2 <= n <= 58

```
/**
 * 343. 整数拆分
 */
public class LeetCode343 {

    public int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {//j最大就是i的一半
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }

    /**
     * 数学方法，求函数y=(n/x)^x(x>0)的最大值，可得x=e时y最大，
     * 但只能分解成整数，故x取2或3，由于6=2+2+2=3+3，显然2^3=8<9=3^2,故应分解为多个3
     */
    public int integerBreak2(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = 1;
        while (n > 4) {
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }
}

```