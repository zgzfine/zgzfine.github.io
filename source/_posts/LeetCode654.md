---
title: LeetCode 654. 最大二叉树
date: 2022-10-22 18:30:35
tags:
categories:

- LeetCode
- 二叉树

---
给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:

* 创建一个根节点，其值为nums 中的最大值。
* 递归地在最大值左边的子数组前缀上构建左子树。
* 递归地在最大值 右边 的子数组后缀上构建右子树。

返回nums 构建的 最大二叉树 。

<!--more-->

示例 1：
![](../images/leetcode654/tree1.jpg)

输入：nums = [3,2,1,6,0,5]  
输出：[6,3,5,null,2,0,null,null,1]  
解释：递归调用如下所示：

- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
          示例 2：

输入：nums = [3,2,1]  
输出：[3,null,2,null,1]

提示：

* 1 <= nums.length <= 1000
* 0 <= nums[i] <= 1000
* nums 中的所有整数 互不相同

```
/**
 * 根据题意，就是使用中序遍历，先确立当前节点，然后在确立左子树，右子树
 */
public TreeNode constructMaximumBinaryTree(int[] nums) {
    //数组是空，那么就返回null节点
    if (nums == null || nums.length == 0) {
        return null;
    }
    //确立当前节点，就需要查询当前数组中的最大值，这里是O（N）
    int size = nums.length - 1;
    int maxNum = -1;//根据题意，数组数值大于等于0
    int maxIndex = -1;
    while (size >= 0) {
        if (nums[size] > maxNum) {
            maxNum = nums[size];
            maxIndex = size;
        }
        size--;
    }
    TreeNode curNode = new TreeNode(maxNum);
    //构造左子树
    curNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
    //构造右子树
    curNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
    //返回当前节点
    return curNode;
}

```


