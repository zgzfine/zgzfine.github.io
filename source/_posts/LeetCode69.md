---
title: LeetCode 69. x 的平方根
date: 2022-10-04 00:19:06
tags:
---

> 给你一个非负整数 x ，计算并返回x的 算术平方根 。  
> 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。  
> 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。  
> 

<!--more--> 

> 输入：x = 4  
> 输出：2
> 
> 输入：x = 8  
> 输出：2  
> 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。  
> 
 
~~~
/**
 * 暴力算法一般容易超出时间限制
 */
public static int baoLi(int x) {
    for (int i = 0; i <= x; i++) {
        int a = i * i;
        if (a == x) {
            return i;
        }
        if (a > x) {
            return i - 1;
        }
    }
    return x;
}

/**
 * 二分法 0 ~ x 之间切割
 */
public static int twoSplit(int x) {
    int l = 0;
    int r = x;
    int ans = -1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        //这里需要转换long，防止溢出
        if ((long) mid * mid <= x) {
            l = mid + 1;
            //ans必须要在l这边，因为题意是要的商
            ans = mid;
        } else {
            r = mid - 1;
        }
    }
    return ans;
}
~~~