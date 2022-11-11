---
title: LeetCode 135. 分发糖果
date: 2022-11-11 16:07:50
tags:
categories:
- LeetCode
- 贪心算法
---

n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

你需要按照以下要求，给这些孩子分发糖果：

* 每个孩子至少分配到 1 个糖果。
* 相邻两个孩子评分更高的孩子会获得更多的糖果。

请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

<!--more-->
示例1：
输入：ratings = [1,0,2]  
输出：5  
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。  

示例2：
输入：ratings = [1,2,2]    
输出：4  
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。  
第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。    


提示：
* n == ratings.length  
* 1 <= n <= 2 * 10^4
* 0 <= ratings[i] <= 2 * 10^4

```
public class LeetCode135 {

    /**
     * 这道题困难的一点是不能排序，同时需要最少的糖果
     * 假如从左到右判断，右比左大，右=左+1
     * 假如从右到左判断，左比右大，左=右+1或者左，两者谁大取谁
     * 在统计一下糖果的数量，那么就可以结局这道题
     */
    public int candy(int[] ratings) {
        int[] cd = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            cd[i] = 1;//每个小朋友都必须要有糖
            if (i > 0) {
                if (ratings[i] > ratings[i - 1])
                    cd[i] = cd[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {//这里从 ratings.length - 2开始就避免最后一个数值的判断
            if (ratings[i] > ratings[i + 1]) {
                cd[i] = Math.max(cd[i], cd[i + 1] + 1);
            }
        }
        return Arrays.stream(cd).sum();
    }
}

```
