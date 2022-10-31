---
title: LeetCode 40. 组合总和 II
date: 2022-10-31 15:44:40
tags:
categories:
- LeetCode
- 回溯
---

给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。  

candidates中的每个数字在每个组合中只能使用一次。  
 
注意：解集不能包含重复的组合。  

<!--more-->

示例1:  
输入: candidates =[10,1,2,7,6,1,5], target =8,  
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

示例2:  
输入: candidates =[2,5,2,1,2], target =5,  
输出:  
[
[1,2,2],
[5]
]


提示:
* 1 <=candidates.length <= 100   
* 1 <=candidates[i] <= 50  
* 1 <= target <= 30  

```
 /**
 * 这题有点 hard的 标星
 * 这道题跟39有点不一样，因为集合里面的元素是有重复的，所以需要解决两个问题
 * 1、数组元素是重复的，怎么解决相同的集合（事后使用set去重，效率有低效）
 * 2、如何结局 （2，6），（6，2） 这种重复集合的问题？可以使用排序后的数组
 */
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
        return rt;
    }
    Arrays.sort(candidates);//转成有序数组
    user = new boolean[candidates.length];//需要一个额外空间保存数值是否有使用过
    Arrays.fill(user, false);//初始化数值
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
        // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
        // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
        // 要对同一树层使用过的元素进行跳过
        if (i > 0 && candidates[i] == candidates[i - 1] && user[i - 1] == false) {
            continue;
        }
        user[i] = true;
        items.offer(candidates[i]);
        sum += candidates[i];
        tracking(candidates, target, i + 1);//因为元素不能重复使用，所以需要调用下一个
        sum -= candidates[i];
        items.removeLast();
        user[i] = false;
    }
}


private List<List<Integer>> rt = new ArrayList<>();

private LinkedList<Integer> items = new LinkedList<>();

private boolean[] user = new boolean[]{};

/**
 * 题数值大于0
 */
private int sum = 0;

```
