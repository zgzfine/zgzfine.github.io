---
title: LeetCode 701. 二叉搜索树中的插入操作
date: 2022-10-24 17:16:24
tags:
categories:
- LeetCode
- 二叉树
---

给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。  
<!--more-->

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。  


示例 1：  
输入：root = [4,2,7,1,3], val = 5   
输出：[4,2,7,1,3,5]  
解释：另一个满足题目要求可以通过的树是：  

示例 2：
输入：root = [40,20,60,10,30,50,70], val = 25    
输出：[40,20,60,10,30,50,70,null,null,25]  

示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5  
输出：[4,2,7,1,3,5]  


提示：
树中的节点数将在[0,10^4]的范围内。
-10^8<= Node.val <= 10^8
所有值Node.val是独一无二的。
-10^8<= val <= 10^8
保证val在原始BST中不存在。


```
/**
 * 二叉树，只需要确保 当前节点大于左子树节点，同时小于右子树的节点即可，不需要管平衡树
 * 以下是前序遍历
 */
public TreeNode insertIntoBST(TreeNode root, int val) {
    //当前节点是空，就直接插入
    if (root == null) {
        return new TreeNode(val);
    }
    if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }
    return root;
}

```

