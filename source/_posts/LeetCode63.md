---
title: LeetCode 63. 不同路径 II
date: 2022-12-07 10:22:16
tags:
categories:
- LeetCode
- 动态规划
---

一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

<!--more-->

示例 1：
![](../images/leetcode63/robot1.jpg)

输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

示例 2：
![](../images/leetcode63/robot2.jpg)

输入：obstacleGrid = [[0,1],[0,0]]
输出：1


提示：

* m ==obstacleGrid.length
* n ==obstacleGrid[i].length
* 1 <= m, n <= 100
* obstacleGrid[i][j] 为 0 或 1

```
/**
 * 63. 不同路径 II
 */
public class LeetCode63 {

    /**
     * 这道题对比62，多了个障碍物，因此有障碍物的地方通道就是0
     * 在题目初始化边界的时候，只要出现障碍物后续的通道都是0
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //这里长高都需要赋值
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //数组行初始化
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;//遇到障碍物后续的不用继续遍历
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;//遇到障碍物后续的不用继续遍历
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}


```