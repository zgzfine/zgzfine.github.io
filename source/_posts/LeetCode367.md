---
title: LeetCode 367. 有效的完全平方数
date: 2022-10-06 16:32:56
tags:
---

> 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。   
> 进阶：不要 使用任何内置的库函数，如 sqrt 。  
> 
>

<!--more-->

> 输入：num = 16   
> 输出：true
> 
> 
> 输入：num = 14  
> 输出：false
>

~~~
/**
 * 由于是正整数，所以可以理解为是正有序的，使用二分法高效
 * 完全平方数，可以理解为，能找到一个正整数，完全满足 N*N=num
 */
public boolean isPerfectSquare(int num) {
    int l = 0;
    int r = num;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        long temp = (long) mid * mid;
        if (temp > num) {
            r = mid - 1;
        } else if (temp < num) {
            l = mid + 1;
        } else {
            return true;
        }
    }
    return false;
}
~~~