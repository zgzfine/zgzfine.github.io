---
title: LeetCode 530. 二叉搜索树的最小绝对差
date: 2022-10-24 12:25:25
tags:
categories:
- LeetCode
- 二叉树
---

给你一个二叉搜索树的根节点 root ，返回 **树中任意两不同节点值之间的最小差值 **。   

差值是一个正数，其数值等于两值之差的绝对值。

<!--more-->

示例 1：
![](../images/leetcode530/bst1.jpg)

输入：root = [4,2,6,1,3]  
输出：1


示例 2：
输入：root = [1,0,48,null,null,12,49]  
输出：1


提示：

树中节点的数目范围是 [2, 104]
0 <= Node.val <= 10^5

> 中序遍历后的节点是有序的!!!
> 中序遍历后的节点是有序的!!!
> 中序遍历后的节点是有序的!!!
> 
> 重要的事情说三遍、三遍、三遍

```

TreeNode pre = null;
//最小值
int min = Integer.MAX_VALUE;

/**
 * 这道题跟 98 差不多，都可以使用中序遍历（遍历后的节点是有序的）
 * 在这个过程中，计算最小值，最后返回数值就可以了
 */
public int getMinimumDifference(TreeNode root) {
    bfs(root);
    return min;
}

public void bfs(TreeNode root) {
    if (root == null) {
        return;//遇到空节点跳过
    }
    //左
    bfs(root.left);

    if (pre != null) {
        min = Math.min(min, root.val - pre.val);
    }
    //注意不管当前有没有值，都需要左赋值操作
    pre = root;

    //右
    bfs(root.right);
}

```