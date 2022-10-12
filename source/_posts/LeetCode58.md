---
title: LeetCode 58 - II. 左旋转字符串
date: 2022-10-12 17:37:33
tags: 翻转
categories:
- LeetCode
- 字符串
---

> 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。  
> 
<!--more-->

示例 1：

输入: s = "abcdefg", k = 2  
输出:"cdefgab"  

示例 2：  

输入: s = "lrloseumgh", k = 6  
输出:"umghlrlose"

限制：  
1 <= k < s.length <= 10000  

```
/**
 * 一般看到翻转字符串，必须要想要双指针以及，通过两次翻转,局部翻转以及全局翻转从而达到目的
 */
public String reverseLeftWords(String s, int n) {
    char[] chars = s.toCharArray();
    reserse(chars, 0, n - 1);
    reserse(chars, n, chars.length - 1);
    reserse(chars, 0, chars.length - 1);
    return new String(chars);
}

/**
 * @param c 字符数组
 * @param l 左指针
 * @param r 右指针
 */
public static void reserse(char[] c, int l, int r) {
    while (l < r) {
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        l++;
        r--;
    }
}

```
