---
title: LeetCode 96. 不同的二叉搜索树
date: 2022-12-07 16:38:06
tags:
categories:
- LeetCode
- 动态规划
---

给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

<!--more-->
示例 1：
![](../images/leetcode96/uniquebstn3.jpg)

输入：n = 3
输出：5
示例 2：

输入：n = 1
输出：1


提示：

* 1 <= n <= 19

```
/**
 * 96. 不同的二叉搜索树
 */
public class LeetCode96 {

    /**
     * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，
     * 右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
     * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

```