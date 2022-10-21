---
title: LeetCode 104. 二叉树的最大深度
date: 2022-10-21 10:47:02
tags: 递归
categories:
- LeetCode
- 二叉树
---

> 给定一个二叉树，找出其最大深度。  
> 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。  
> 说明: 叶子节点是指没有子节点的节点。  
> 
<!--more-->

示例：
给定二叉树 [3,9,20,null,null,15,7]，

 3
/ \
9  20
/  \
15   7
返回它的最大深度3 。

ps:在leetcode上，一个节点算深度1

```
/**
 * 一般二叉树，链表，数据结构相似，使用递归会比较容易得出结论
 * 1、求左子树的最大深度
 * 2、求右子树的最大深度
 * 3、Math.max(左右子树) ，再加 1
 */
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = maxDepth(root.left);
    int rigth = maxDepth(root.right);
    return Math.max(left, rigth) + 1;
}
```

