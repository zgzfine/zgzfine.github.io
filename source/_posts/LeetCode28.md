---
title: LeetCode 28. 找出字符串中第一个匹配项的下标
date: 2022-10-13 17:08:47
tags: KMP
categories:

- LeetCode
- 字符串

---

> 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回 -1 。
<!--more-->

示例 1：
输入：haystack = "sadbutsad", needle = "sad"  
输出：0  
解释："sad" 在下标 0 和 6 处匹配。  
第一个匹配项的下标是 0 ，所以返回 0 。  

示例 2：  
输入：haystack = "leetcode", needle = "leeto"  
输出：-1  
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。  


提示：
1 <= haystack.length, needle.length <= 104  
haystack 和 needle 仅由小写英文字符组成  


> 典型的KMP算法题，初次接触，只有一面懵逼

```
public class LeetCode28 {

    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        int i = leetCode28.strStr("klofefegre", "fef");
        System.out.println(i);
    }

    /**
     * 如果单纯是暴力算法，那么时间复杂度是 O（n*m） 文本串以及模式串，所以需要使用KMP算法
     * KMP题目，主要是构建 next 数组，就是回退数组、前缀表，用于帮助当前函数哪里需要回退使用的
     * 主函数的推算跟next数组的构建类似，也是主要是三部
     * 1、初始化起始值
     * 2、处理字符不匹配的情况
     * 3、处理字符匹配的情况
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        int[] next = new int[needle.length()];//定义一个next数组，长度为模式串的长度
        getNext(next, needle);//初始化next数组
        int j = -1;//模式串的起始位置，因为数组里面的最低是-1
        for (int i = 0; i < haystack.length(); i++) {//文本串直接从0开始
            //处理不相等的情况
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            //处理相等的情况
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            //判断是否已经结束,j+1已经到模式串的末尾
            if (j + 1 == needle.length()) {
                return i - needle.length() + 1;//末尾需要文本串减去模式串 再 +1
            }
        }
        return -1;

    }

    /**
     * 根据模式寸在数组 next 中赋值
     * 1、初始化起始值，定义 j，i变量，j为前缀末，i为后缀末
     * 2、前缀末与后缀末不相等的情况
     * 3、前缀末与后缀末相等的情况
     * 如 s = aabaaf;
     */
    public static void getNext(int[] next, String s) {
        int j = -1;//使用next数组，起始值-1，主要是避免数值为0，循环超出数组的问题
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {//由于j已经是第一个值，那么i从坐标1开始
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {//由于j初始-1，所以这里需要+1
                j = next[j];//如果不相等，j需要回推到next[j]所指的下标
            }
            if (s.charAt(i) == s.charAt(j + 1)) {//处理相等的情况
                j++;
            }
            next[i] = j;//只有i是每次都递增1，j是不断变化的
        }
    }
}

```

