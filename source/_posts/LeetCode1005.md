---
title: LeetCode 1005. K 次取反后最大化的数组和
date: 2022-11-11 10:47:29
tags:
categories:
- LeetCode
- 贪心算法
---

给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：  

选择某个下标 i并将 nums[i] 替换为 -nums[i] 。  
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。  

以这种方式修改数组后，返回数组 **可能的最大和** 。  


<!--more-->

示例 1：

输入：nums = [4,2,3], k = 1  
输出：5  
解释：选择下标 1 ，nums 变为 [4,-2,3] 。  

示例 2：

输入：nums = [3,-1,0,2], k = 3  
输出：6  
解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。  

示例 3：

输入：nums = [2,-3,-1,5,-4], k = 2  
输出：13  
解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。  


提示：

* 1 <= nums.length <= 10^4
* -100 <= nums[i] <= 100
* 1 <= k <= 10^4

```

/**
 * 1005. K 次取反后最大化的数组和
 */
public class LeetCode1005 {

    /**
     * 1、将数组按绝对值后从大到小排序
     * 2、将k个负数的值翻转
     * 3、假如数组的值都是大于等于0，还有剩下的数值次数没翻转，就接着翻转剩下的
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums)
                .boxed()//装箱
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))//反序
                .mapToInt(Integer::valueOf).toArray();//类型转换
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];//数值翻转在赋值
                k--;//找到负数了，需要减1
            }
        }
        if (k % 2 == 1) {//如果k大于0，并且k是奇数，那么需要将数组最后一个数值翻转一次
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        return Arrays.stream(nums).sum();//数值相加
    }
}
```