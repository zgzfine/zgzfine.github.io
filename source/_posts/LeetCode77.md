---
title: LeetCode 77. 组合
date: 2022-10-28 10:35:21
tags: 
- 组合
categories:
- LeetCode
- 回溯
---

给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。  
你可以按 任何顺序 返回答案。  

<!--more-->

示例 1：  
输入：n = 4, k = 2  
输出：  
[  
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]  

示例 2：
输入：n = 1, k = 1  
输出：[[1]]  


提示： 
* 1 <= n <= 20  
* 1 <= k <= n  

Ps：这是一道经典的组合回溯题，需要经常回顾细品。
![](../images/leetcode77/20201123195242899.png)

```
/**
 * 这道题需要的是组合，组合是不需要考虑顺序，所以每个都参与组合操作
 * 一般组合，排序都是使用回溯法，回溯法其实就是暴力破解的升级版，是一款穷举的破解法
 * 回溯法的好处是，使用递归的编程方式，隐盖了原本需要多个for循环的操作
 */
public List<List<Integer>> combine(int n, int k) {
    tracking(n, k, 0);
    return rel;
}

public void tracking(int n, int k, int stId) {
    //如果item的数量等于 k，那么就把数据copy一份到结果集
    if (item.size() == k) {
        rel.add(new ArrayList<>(item));
        return;
    }
    for (int i = stId; i <= n - (k - item.size()) + 1; i++) {//这里需要做一个剪枝的操作,简单的理解,i的最大值为：n-k+1(+1是因为两个数值相减后需要加一才是距离)，细品~
        //每次操作一个元素，入栈
        item.add(i);
        tracking(n, k, i + 1);//当前节点i已经使用过了，所以需要在当前节点+1;切记这里使用的是i，而不是stId
        //出栈
        item.removeLast();
    }
}

/**
 * 结果集合
 */
private List<List<Integer>> rel = new ArrayList<>();

/**
 * 每次的结果集
 */
private LinkedList<Integer> item = new LinkedList<>();
```
