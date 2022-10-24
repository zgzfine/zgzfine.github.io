---
title: LeetCode 236. 二叉树的最近公共祖先
date: 2022-10-24 15:19:49
tags:
categories:

- LeetCode
- 二叉树

---

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

<!--more-->

示例 1：  
![](../images/leetcode236/binarytree.png)

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1  
输出：3  
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

示例 2：  
![](../images/leetcode236/binarytree.png)

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4  
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

示例 3：
输入：root = [1,2], p = 1, q = 2  
输出：1

提示：

树中节点数目在范围 [2, 10^5] 内。
-10^9 <= Node.val <= 10^9
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。

> 实在话，这道题代码量不大，但是也挺考验个人的空间思维能力，而且使用迭代法会复杂很多。  
> 面试考到的几率估计会大点

```
 /**
 * 查询最近公共祖先，最好是能从下到上遍历树，后序遍历就是目的
 * 假如在遍历的过程中，左右节点都能找到，不为空，那么当前的中节点就是他们的最小公共祖先
 */
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //当找到对应的节点，那么就返回，null节点返回空,由于每个节点遍历一次，所以这里的不会出现root==p等下又遇到的情况
    if (root == p || root == q || root == null) {
        return root;
    }
    //左
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    //右
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {//左右节点都找到值，返回当前节点
        return root;
    } else if (right == null) {//如果右节点为空就返回 左节点
        return left;
    } else {
        return right;//否则返回右节点
    }
}

```
