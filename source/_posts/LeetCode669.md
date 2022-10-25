---
title: LeetCode 669. 修剪二叉搜索树
date: 2022-10-25 14:21:47
tags:
categories:
- LeetCode
- 二叉树
---

给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。

<!--more-->
通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 **唯一** 的答案。

所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。


示例 1：
![](../images/leetcode669/trim1.jpg)

输入：root = [1,0,2], low = 1, high = 2  
输出：[1,null,2]  


示例 2：
![](../images/leetcode669/trim2.jpg)

输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3  
输出：[3,2,null,1]  


提示：

* 树中节点数在范围 [1, 10^4] 内
* 0 <= Node.val <= 10^4
* 树中每个节点的值都是 唯一 的
* 题目数据保证输入是一棵有效的二叉搜索树
* 0 <= low <= high <= 10^4


```
/**
 * 使用的是中序遍历
 */
public TreeNode trimBST(TreeNode root, int low, int high) {
    //如果达到了底层，那么就返回空
    if (root == null) {
        return null;
    }
    //节点不为空
    if (root.val < low) {
        //如果当前节点的值比最小范围还要小，那么就删除当前节点以及左孩子树,但是需要返回 已经遍历过的右子树
        //因为右子树可能也有不在这个范围的节点
        return trimBST(root.right, low, high);
    }
    if (root.val > high) {
        return trimBST(root.left, low, high);//与上同理
    }
    //接着就递归左孩子以及右孩子
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
}

```

