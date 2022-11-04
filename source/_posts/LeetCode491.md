---
title: LeetCode 491. 递增子序列
date: 2022-11-04 16:31:47
tags:
categories:
- LeetCode
- 回溯
---

给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。  
数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。  

<!--more--> 
示例 1：  
输入：nums = [4,6,7,7]  
输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]  

示例 2：  
输入：nums = [4,4,3,2,1]  
输出：[[4,4]]  


提示：  
* 1 <= nums.length <= 15  
* -100 <= nums[i] <= 100  


```
/**
 * 题目其实求解的是递增子序列，但是我们不能给数组排序，是按原有的顺序进行排列的
 */
public List<List<Integer>> findSubsequences(int[] nums) {
    tracking(nums, 0);
    return rt;
}

public void tracking(int[] nums, int startId) {
    if (item.size() > 1) {//当子集的数量大于0，就可以放到结果集里面了
        rt.add(new ArrayList<>(item));
        //这里不能使用return,因为子集的数量是越来越大的，后续的字段还需要加入
    }
    //需要判断同一层的元素是否已经使用过，使用过就代表需要剪枝，使用set判断重复，同一层可以理解为同一个startId
    HashSet<Integer> set = new HashSet<>();
    for (int i = startId; i < nums.length; i++) {
        //如果使用过的数值，需要跳过
        if (set.contains(nums[i])) {
            continue;
        }
        //如果当前的元素比上加入集合的元素要小，就跳过
        if (item.peekLast() != null && item.peekLast() > nums[i]) {
            continue;
        }
        set.add(nums[i]);
        item.add(nums[i]);
        tracking(nums, i + 1);
        item.removeLast();
    }
}

private List<List<Integer>> rt = new ArrayList<>();

private LinkedList<Integer> item = new LinkedList<>();

```

