---
title: LeetCode 111. 二叉树的最小深度
date: 2022-10-18 15:53:12
tags:
categories:
- LeetCode
- 二叉树
---

> 给定一个二叉树，找出其最小深度。
<!--more-->

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

示例 1：
输入：root = [3,9,20,null,null,15,7]  
输出：2  

示例 2：  
输入：root = [2,null,3,null,4,null,5,null,6]  
输出：5

提示：
树中节点数的范围在 [0, 105] 内  
-1000 <= Node.val <= 1000  

```
/**
 * 相比于求二叉树最大深度，求最小深度也能使用层序遍历，当层序遍历遇到左右孩子都是null的时候，就是找到最小深度的
 */
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> qe = new LinkedList<>();
    qe.offer(root);
    int depth = 0;
    while (!qe.isEmpty()) {
        depth++;
        int size = qe.size();
        while (size-- > 0) {
            TreeNode node = qe.poll();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                qe.offer(node.left);
            }
            if (node.right != null) {
                qe.offer(node.right);
            }
        }
    }
    return depth;
}

```