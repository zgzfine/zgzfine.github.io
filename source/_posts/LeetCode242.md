---
title: LeetCode 242. 有效的字母异位词
date: 2022-10-10 11:47:25
tags:
categories:

- LeetCode
- 哈希表

---

>
> 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
>
<!--more-->
> 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
>
> 输入: s = "anagram", t = "nagaram"  
> 输出: true
>
> 输入: s = "rat", t = "car"
> 输出: false
>

```
/**
 * 一般判断是否有数字存在存在过，都是使用哈希映射
 * 一般的映射包括 数组、set、哈希表
 * 本题目较简单，仅仅使用数组即可解决
 * 由于使用题目说道只是小写字母，所以就需要一个额外存储空间，大小为26的数组
 * 1、将 s 串字符拆分放到数组中，相同字符，数字+1
 * 2、将 t 串字符拆分遍历，判断在数组中数字-1
 * 3、判断数组各项值是否都是0
 */
public boolean isAnagram(String s, String t) {
    int[] temp = new int[26];
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        char aChar = chars[i];
        int a = aChar - 'a';//a为最小的下标，初始值0
        temp[a]++;
    }
    char[] chart = t.toCharArray();
    for (int i = 0; i < chart.length; i++) {
        int b = chart[i] - 'a';
        temp[b]--;
    }
    for (int i = 0; i < temp.length; i++) {
        if (temp[i] != 0) {
            return false;
        }
    }
    return true;
}

```