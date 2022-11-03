---
title: LeetCode 131. 分割回文串
date: 2022-11-03 15:40:40
tags: 回文子串
categories:

- LeetCode
- 回溯

---

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 **回文串** 。返回 s 所有可能的分割方案。

**回文串** 是正着读和反着读都一样的字符串。

<!--more-->  
示例 1：
输入：s = "aab"  
输出：[["a","a","b"],["aa","b"]]

示例 2：
输入：s = "a"  
输出：[["a"]]

提示：
1 <= s.length <= 16
s 仅由小写英文字母组成

```
 /**
 * 本地是一个回溯题目
 * 递归的深度就是s的长度，广度就是从每一层开始切割的位置到s的最右方
 */
public List<List<String>> partition(String s) {
    tracking(s, 0);
    return rt;
}


public void tracking(String s, int startId) {
    if (startId >= s.length()) {
        rt.add(new ArrayList<>(item));
    }

    for (int i = startId; i < s.length(); i++) {
        //如果从startId 到 i是回文，那么放到子集
        if (huiWen(s, startId, i)) {
            item.add(s.substring(startId, i + 1));
        } else {
            continue;//不是回文串，接续for循环
        }
        tracking(s, i + 1);//从i+1为其实位置，继续递归下去
        item.removeLast();//回溯，需要弹出已经装填的子串（因为该子串已经在数组里面，避免重复所以需要弹出）
    }
}

/**
 * 判断是否回文使用双指针
 * 回文串 是正着读和反着读都一样的字符串。
 */
private boolean huiWen(String s, int start, int end) {
    int l = start;
    int r = end;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}

/**
 * 结果集的存放
 */
private List<List<String>> rt = new ArrayList<>();

private LinkedList<String> item = new LinkedList<>();

```