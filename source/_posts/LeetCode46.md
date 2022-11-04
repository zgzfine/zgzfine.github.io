---
title: LeetCode 46. 全排列
date: 2022-11-04 17:02:11
tags: 全排序
categories:
- LeetCode
- 回溯
---

给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 **按任意顺序** 返回答案。

<!--more-->
示例 1：  
输入：nums = [1,2,3]  
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]  

示例 2：   
输入：nums = [0,1]  
输出：[[0,1],[1,0]]  

示例 3：  
输入：nums = [1]  
输出：[[1]]  

提示：
* 1 <= nums.length <= 6
* -10 <= nums[i] <= 10
* nums 中的所有整数 互不相同


```
/**
 * 全排序的关键是，需要一个额外数组纪录目前的节点使用情况
 * 遍历的时候，每次都必须要从0开始
 */
public List<List<Integer>> permute(int[] nums) {
    user = new boolean[nums.length];
    Arrays.fill(user, false);
    tracking(nums);
    return rt;
}

public void tracking(int[] nums) {
    //介绍条件是当结果集合的等于数组长度的时候，其实全排序就是 满二叉树
    if (item.size() == nums.length) {
        rt.add(new ArrayList<>(item));
        return;
    }
    //这里跟组合不同的一点是，全排序每次都必须是从0开始遍历的
    for (int i = 0; i < nums.length; i++) {
        //如果当前数字已经使用，那么就需要跳过
        if (user[i]) {
            continue;
        }
        user[i] = true;
        item.add(nums[i]);
        tracking(nums);
        item.removeLast();
        //需要回溯，历史需要还原，嘿嘿
        user[i] = false;
    }
}

/**
 * 结果集
 */
private List<List<Integer>> rt = new ArrayList<>();

private LinkedList<Integer> item = new LinkedList<>();

/**
 * 使用数组判断是否已经使用过
 */
private boolean[] user = new boolean[0];


```

    