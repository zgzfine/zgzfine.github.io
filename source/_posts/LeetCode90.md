---
title: LeetCode 90. 子集 II
date: 2022-11-07 16:41:17
tags:
categories:

- LeetCode
- 回溯

---

给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 **任意顺序** 排列。

<!--more-->

示例 1：
输入：nums = [1,2,2]  
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

示例 2：  
输入：nums = [0]  
输出：[[],[0]]

提示：

* 1 <= nums.length <= 10
* -10 <= nums[i] <= 10

```
 /**
 * 根据题意，可以分析到这个应该就是组合的问题，所以有以下几点是可以总结出来的
 * 1、这里获取的是子集，一般子集就是所以节点（组合、排序都是就是叶子几点）
 * 2、去重可以思考按有序的数组来实现，会有同层去重，同树枝去重
 * 3、求子集，会要求使用已用数组来作为辅助工具
 */
public List<List<Integer>> subsetsWithDup(int[] nums) {
    used = new boolean[nums.length];
    Arrays.fill(used, false);//初始化为false
    Arrays.sort(nums);//数组排序
    tracking(nums, 0);
    return rt;
}

private void tracking(int[] nums, int startId) {
    rt.add(new ArrayList<>(item));//组合里面每次有元素都要添加到结果集里面，这里是求子集,注意，空数组也是一个子集
    for (int i = startId; i < nums.length; i++) {
        //需要判断是否有重复，也就是同层过滤
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue;
        }
        used[i] = true;
        item.add(nums[i]);
        tracking(nums, i + 1);
        item.removeLast();
        used[i] = false;
    }
}

private List<List<Integer>> rt = new ArrayList<>();

private LinkedList<Integer> item = new LinkedList<>();

private boolean[] used = new boolean[]{};

```