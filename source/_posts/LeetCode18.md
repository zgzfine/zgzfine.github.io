---
title: LeetCode 18. 四数之和
date: 2022-10-12 14:58:36
tags:
categories:

- LeetCode
- 双指针

---

> 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
> （若两个四元组元素一一对应，则认为两个四元组重复）
>
<!--more-->



示例 1：  
输入：nums = [1,0,-1,0,-2,2], target = 0  
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

示例 2：
输入：nums = [2,2,2,2,2], target = 8  
输出：[[2,2,2,2]]

提示：  
1 <= nums.length <= 200  
-109 <= nums[i] <= 109  
-109 <= target <= 109

```
/**
 * 可以参考三数之和，其中这里多了一个条件，等于target，所以去重的时候需要考量的不一样
 * 其实双指针就是比暴力破解减少一层循环，实际上时间复杂度就是 O(N^3)
 */
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    //直接使用函数的排序算法，一般时间复杂度都是 O(N^2)或者O(NlogN)
    Arrays.sort(nums);
    //根据
    for (int i = 0; i < nums.length - 3; i++) {
        /**
         * 三数之和 可以通过 nums[i] > 0 就返回了，因为 0 已经是确定的数了，四数之和这道题目 target是任意值。
         * 比如：数组是[-4, -3, -2, -1]，target是-10，不能因为-4 > -10而跳过
         */
        if (nums[i] > 0 && nums[i] > target) {
            break;//统一最后的结果返回
        }
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        for (int j = i + 1; j < nums.length; j++) {
            //经过排序后的数组,首数字不能大于target，不然后续就不需要遍历,这块算是折枝的手段
            if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target) {
                break;
            }
            /**
             * 特别关键的步骤
             * i 至少等于1
             * 跟前一个数值对比，如果相等，那么就意味这可以过滤调重复的组合
             * 反过来如果是跟后面的一个数值对比，那么就可能缺失以下的这种情况 [-1,-1,2]，这里需要细致思考
             * 如果不用这种方法排除，使用set，那么时间复杂度可能达不到
             */
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }

            int left = j + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[j] + nums[left] + nums[right];
                if (sum > target) {
                    right--;//如果大于零 右缩
                } else if (sum < target) {
                    left++;//如果小于零，左涨
                } else {
                    //否则找到正确数值，录入结果集，并且左右涨缩
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
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
    }
    return result;
}
```
