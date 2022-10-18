---
title: LeetCode 1302. 层数最深叶子节点的和
date: 2022-10-18 10:20:46
tags:
categories:
- LeetCode
- 二叉树
---

> 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
> ![](../images/leetcode1302/1483_ex1.png)
> 
<!--more-->

示例 1：  
输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]  
输出：15  

示例 2：  
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]  
输出：19  

提示：

树中节点数目在范围 [1, 104]之间。  
1 <= Node.val <= 100  

Ps:原来本blog第一篇日志的题目是出自这里，哈哈哈，那么就用不一样的解法吧

```
public int deepestLeavesSum(TreeNode root) {
    Queue<TreeNode> qe = new LinkedList<>();
    qe.offer(root);
    int sum = 0;
    while (!qe.isEmpty()) {
        sum = 0;//由于需要统计最深节点的和，所以每次都需要归零
        int size = qe.size();
        while (size-- > 0) {
            TreeNode node = qe.poll();
            if (node != null) {
                sum = sum + node.val;
                if (node.left != null) {
                    qe.add(node.left);
                }
                if (node.right != null) {
                    qe.add(node.right);
                }
            }
        }
    }
    return sum;
}
```

