---
title: LeetCode 541. 反转字符串 II
date: 2022-10-12 15:37:38
tags:
categories:
- LeetCode
- 字符串
---

>给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。  

<!--more-->
> 如果剩余字符少于 k 个，则将剩余字符全部反转。  
> 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。  


示例 1：

输入：s = "abcdefg", k = 2  
输出："bacdfeg"  
示例 2：  

输入：s = "abcd", k = 2  
输出："bacd"  


提示：  

1 <= s.length <= 104  
s 仅由小写英文组成  
1 <= k <= 104  

```
/**
 * 这道题主要是找到需要翻转字符的下标
 * i 每次递增都是 2k
 */
public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    //i的起点每次递增2k
    for (int i = 0; i < chars.length; i = i + 2 * k) {
        if (i + k > chars.length - 1) {
            reverseChar(chars, i, chars.length - 1);
        } else {
            reverseChar(chars, i, i + k - 1);
        }
    }
    return new String(chars);
}

public static void reverseChar(char[] chars, int l, int r) {
    while (l < r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        l++;
        r--;
    }
}

```