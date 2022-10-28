---
title: LeetCode 17. 电话号码的字母组合
date: 2022-10-28 12:08:07
tags: 
- 组合
categories:
- LeetCode
- 回溯
---

给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
![](../images/leetCode17/200px-telephone-keypad2svg.png)

<!--more-->

示例 1：  
输入：digits = "23"  
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]  

示例 2：
输入：digits = ""  
输出：[]  

示例 3：
输入：digits = "2"  
输出：["a","b","c"]  

提示：
0 <= digits.length <= 4  
digits[i] 是范围 ['2', '9'] 的一个数字。  

```
 /**
 * 映射map
 */
public HashMap<Character, String> map = new HashMap<Character, String>() {
    {
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }
};

public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
        return rt;
    }
    tracking(digits, 0);
    return rt;
}

/**
 * st
 *
 * @param digits 字符串
 * @param start  字符串的下标，从零开始
 */
public void tracking(String digits, int start) {
    if (start == digits.length()) {//已经遍历完了
        rt.add(item);
        return;
    }
    char c = digits.charAt(start);
    String st = map.get(c);
    for (char a : st.toCharArray()) {
        String temp = item;
        item = item + a;//这里需要优化一下，不然性能有点卡
        tracking(digits, start + 1);
        item = temp;
    }
}

public List<String> rt = new ArrayList<>();

public String item = new String();


```