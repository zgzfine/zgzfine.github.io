---
title: LeetCode 904. 水果成篮
date: 2022-10-06 16:36:14
tags: LeetCode
categories:
- LeetCode
- 数组
---

> 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。     
> 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
> * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
> * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
> * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
>
> 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
>

<!--more-->

> 输入：fruits = [1,2,1]  
> 输出：3  
> 解释：可以采摘全部 3 棵树。  

~~~
/**
 * 根据题意，意思是从数组的随意一个下标开始往右走，遇到的数值类型只能是两种，那么从哪下标开始走，走过的路程最远
 * 这道题就是典型的滑动窗口+权重比例
 * 需要额外的添加权重哈希参数
 */
public int totalFruit(int[] fruits) {
    int ans = 0;
    int i = 0;//初始化左指针，就是滑动窗口的左指针
    Counter counter = new Counter();
    //使用哈希篮子
    //外循环从头遍历到尾
    for (int j = 0; j < fruits.length; j++) {
        counter.add(fruits[j]);
        while (counter.size() > 2) {
            //如果篮子种类多余两种，需要去除前面添加的那些,这里的i会缩小，不断将之前添加的数值移除
            //当移除到一定程度，篮子剩下就只有最多两种水果，这是这道题最关键的地方
            counter.remote(fruits[i++]);
        }
        ans = Math.max(j - i + 1, ans);
    }
    return ans;
}

static class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k) {
        int i = get(k);
        if (i == 0) {
            super.put(k, 1);
        } else {
            super.put(k, i + 1);
        }
    }

    public void remote(int k) {
        int i = get(k);
        if (i == 1) {
            //如果值等于0，移除
            super.remove(k);
        } else {
            super.put(k, i - 1);
        }
    }
}
~~~