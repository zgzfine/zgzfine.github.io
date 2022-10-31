---
title: LeetCode 39. 组合总和
date: 2022-10-31 15:09:49
tags:
categories:
- LeetCode
- 回溯
---

给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

对于给定的输入，保证和为target 的不同组合数少于 150 个。

<!--more-->


示例1：  
输入：candidates = [2,3,6,7], target = 7  
输出：[[2,2,3],[7]]  
解释：  
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。  
7 也是一个候选， 7 = 7 。  
仅有这两种组合。  

示例2：  
输入: candidates = [2,3,5], target = 8  
输出: [[2,2,2,2],[2,3,3],[3,5]]  

示例 3：  
输入: candidates = [2], target = 1  
输出: []  

提示：  
* 1 <= candidates.length <= 30  
* 2 <= candidates[i] <= 40  
* candidates 的所有元素 互不相同  
* 1 <= target <= 40   

```
/**
 * 本题的要求是当前元素可以重复使用，那么递归的时候只需要把自身下标传进去就可以了
 * 同样也需要一个结果集，装载目前数字的小集合
 */
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    tracking(candidates, target, 0);
    return rt;
}

public void tracking(int[] candidates, int target, int startId) {
    if (sum > target) {
        return;
    }
    if (sum == target) {
        rt.add(new ArrayList<>(items));
        return;
    }
    for (int i = startId; i < candidates.length; i++) {
        items.offer(candidates[i]);
        sum += candidates[i];
        tracking(candidates, target, i);//此处是关键点，因为集合的元素可以重复使用，用这里是i而不是i+1
        sum -= candidates[i];
        items.removeLast();
    }
}

/**
 * 结果集
 */
private List<List<Integer>> rt = new ArrayList<>();

/**
 * 小集合，用来回溯使用的（使用双端队列比较好操作）
 */
private LinkedList<Integer> items = new LinkedList<>();

/**
 * 使用额外的sum，简化计算
 */
private int sum = 0;

```



