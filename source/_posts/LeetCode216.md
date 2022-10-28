---
title: LeetCode 216. 组合总和 III
date: 2022-10-28 11:35:12
tags: 组合
categories:
- LeetCode
- 回溯
---

找出所有相加之和为n 的k个数的组合，且满足下列条件：  

* 只使用数字1到9  
* 每个数字最多使用一次  

返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。  

<!--more-->

示例 1:  
输入: k = 3, n = 7  
输出: [[1,2,4]]  
解释:  
1 + 2 + 4 = 7  
没有其他符合的组合了。  


示例 2:  
输入: k = 3, n = 9  
输出: [[1,2,6], [1,3,5], [2,3,4]]  
解释:  
1 + 2 + 6 = 9  
1 + 3 + 5 = 9  
2 + 3 + 4 = 9  
没有其他符合的组合了。  

示例 3:  
输入: k = 4, n = 1  
输出: []  
解释: 不存在有效的组合。  
在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。  


提示:  
2 <= k <= 9  
1 <= n <= 60  

```
/**
 * 简单理解就是 k个数之和等于n
 */
public List<List<Integer>> combinationSum3(int k, int n) {
    tracking(k, n, 1);
    return rt;
}

/**
 * 回溯递归
 * 1、需要一个装载数据的容器
 * 2、需要一个装载结果集合的容器
 * 3、需要统计相加目前的值 sum;
 */
public void tracking(int k, int n, int stId) {
    if (sum > n) {//目前的数值大于n，返回上一层
        return;
    }
    if (item.size() == k && sum == n) {//符合条件，装载结果集
        rt.add(new ArrayList<>(item));
        return;
    }
    for (int i = stId; i < 10 - (k - item.size()) + 1; i++) {//题目限制了 1~9
        item.offer(i);
        sum += i;
        tracking(k, n, i + 1);
        item.removeLast();//回溯
        sum -= i;
    }

}

private List<List<Integer>> rt = new ArrayList<>();

private LinkedList<Integer> item = new LinkedList<>();

private int sum = 0;

```
    