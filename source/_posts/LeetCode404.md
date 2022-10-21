---
title: LeetCode 404. 左叶子之和
date: 2022-10-21 15:54:50
tags:
categories:
- LeetCode
- 字符串
---

给定二叉树的根节点 root，返回所有左叶子之和。

<!--more-->

示例 1：

![](../images/leetcode404/leftsum-tree.jpg)  

输入: root = [3,9,20,null,null,15,7]  
输出: 24  
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24  

示例2:
输入: root = [1]  
输出: 0  

提示:
节点数在[1, 1000]范围内  
-1000 <= Node.val <= 1000  

```
/**
 * 根节点不是叶子节点
 */
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }
    if (root.left == null && root.right == null) {
        return 0;//这步要主要，当前节点没有孩子节点，所以当前节点是叶子节点，应该返回0
    }
    int leftint = sumOfLeftLeaves(root.left);
    if (root.left != null && root.left.left == null && root.left.right == null) {//判断当节点的左节点是否是叶子节点
        leftint = leftint + root.left.val;
    }
    int rightint = sumOfLeftLeaves(root.right);
    return leftint + rightint;
}

```
