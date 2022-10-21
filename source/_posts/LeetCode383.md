---
title: LeetCode 383. 赎金信
date: 2022-10-11 17:07:54
tags:
categories:
- LeetCode
- 字符串
---

> 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。  
> 如果可以，返回 true ；否则返回 false 。  
> magazine 中的每个字符只能在 ransomNote 中使用一次。
 
<!--more-->
示例 1：  
输入：ransomNote = "a", magazine = "b"  
输出：false  

示例 2：  
输入：ransomNote = "aa", magazine = "ab"  
输出：false  

示例 3：  
输入：ransomNote = "aa", magazine = "aab"  
输出：true  

提示：  
1 <= ransomNote.length, magazine.length <= 10^5  
ransomNote 和 magazine 由小写英文字母组成  

```
/**
 * 这道题也相对简单，只需要使用一个map，纪录 magazine里面出现字符的数量，在一个for 循环ransomnote即可
 */
public boolean canConstruct(String ransomNote, String magazine) {
    //根据题意，使用map
    HashMap<Character, Integer> map = new HashMap<>();
    char[] chars = magazine.toCharArray();
    for (char c : chars) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);//存在value+1
        } else {
            map.put(c, 1);//不存在插入
        }
    }
    char[] chars1 = ransomNote.toCharArray();
    for (char d : chars1) {
        if (map.containsKey(d)) {
            map.put(d, map.get(d) - 1);//如果存在，扣减1
            if (map.get(d) == 0) {
                map.remove(d);//如果数值变成0，删除
            }
        } else {
            return false;
        }
    }
    return true;
}

```