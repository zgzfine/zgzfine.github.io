---
title: LeetCode 05. 替换空格
date: 2022-10-12 17:03:56
tags:
categories:
- LeetCode
- 字符串
---

>请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
<!--more-->


示例 1：

输入：s = "We are happy."  
输出："We%20are%20happy."  


限制：  

0 <= s 的长度 <= 10000  

```
 /**
 * 1、统计字符串有多少空格
 * 2、没有空格直接返回
 * 采用双指针，从右往左赋值
 */
public String replaceSpace(String s) {
    if (s == null || s.length() == 0) {
        return s;
    }
    char[] chars = s.toCharArray();
    StringBuilder str = new StringBuilder();
    for (char c : chars) {
        if (c == ' ') {
            //有一个空格，需要多增加两个空格
            str.append("  ");
        }
    }
    //如果没有空格，返回
    if (str.length() == 0) {
        return s;
    }
    //左下标标记原字符串末尾
    int left = s.length() - 1;
    //扩容原数组，不使用新数组
    s = s + str;
    //右下标标记现数组的末尾
    int right = s.length() - 1;
    //开始往左移动，直到左左边数值为0

    char[] charArray = s.toCharArray();
    while (left >= 0) {
        if (charArray[left] == ' ') {//等于空格
            //当前值赋值
            charArray[right] = '0';
            right--;
            charArray[right] = '2';
            right--;
            charArray[right] = '%';//最后
        } else {
            charArray[right] = charArray[left];
        }
        left--;
        right--;
    }
    return new String(charArray);
}
```