---
title: LeetCode 15. 三数之和
date: 2022-10-12 11:10:20
tags:
categories:
- LeetCode
- 双指针
---

> 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。

<!--more-->


> 你返回所有和为 0 且不重复的三元组。  
> 注意：答案中不可以包含重复的三元组。  
> 
>
示例 1：
输入：nums = [-1,0,1,2,-1,-4]  
输出：[[-1,-1,2],[-1,0,1]]  
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。  
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。  
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。  
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。  
注意，输出的顺序和三元组的顺序并不重要。  

示例 2：  
输入：nums = [0,1,1]  
输出：[]  
解释：唯一可能的三元组和不为 0 。  

示例 3：  
输入：nums = [0,0,0]  
输出：[[0,0,0]]  
解释：唯一可能的三元组和为 0 。  

提示：  
  
3 <= nums.length <= 3000  
-105 <= nums[i] <= 105  

```
/**
 * 题目里面的难点
 * 1、时间复杂度
 * 2、不可以包含重复的三元组
 * 假如使用暴力破解那么，这里会有 O(N^3)的时间复杂度
 * 所以考虑减低复杂度，使用 排序+双指针的方法
 * 由于排序的时间复杂度是 O(N*logN),双指针O(N^2) 所有最终时间复杂度O(N*logN)+O(N^2)=O(N^2)
 */
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //直接使用函数的排序算法，一般时间复杂度都是 O(N^2)或者O(NlogN)
    Arrays.sort(nums);
    //根据
    for (int i = 0; i < nums.length - 2; i++) {
        //经过排序后的数组,首数字不能大于0，不然后续就不需要遍历,这块算是折枝的手段
        if (nums[i] > 0) {
            return result;
        }

        /**
         * 特别关键的步骤
         * i 至少等于1
         * 跟前一个数值对比，如果相等，那么就意味这可以过滤调重复的组合
         * 反过来如果是跟后面的一个数值对比，那么就可能缺失以下的这种情况 [-1,-1,2]，这里需要细致思考
         * 如果不用这种方法排除，使用set，那么时间复杂度可能达不到
         */
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;//如果大于零 右缩
            } else if (sum < 0) {
                left++;//如果小于零，左涨
            } else {
                //否则找到正确数值，录入结果集，并且左右涨缩
                List<Integer> item = new ArrayList<>();
                item.add(nums[i]);
                item.add(nums[left]);
                item.add(nums[right]);
                result.add(item);

                /**
                 * 重点2
                 * 去重逻辑应该放在找到一个三元组之后，对left 和 right去重
                 * 针对这种情况，如 [-2,0,0,2,2]
                 */
                while (left < right && nums[right] == nums[right - 1]) right--;
                while (left < right && nums[left] == nums[left + 1]) left++;

                left++;
                right--;
            }
        }
    }
    return result;
}
```

