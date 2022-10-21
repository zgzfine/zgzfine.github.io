---
title: LeetCode 257. 二叉树的所有路径
date: 2022-10-21 11:56:06
tags:
categories:
- LeetCode
- 二叉树
- 回溯
---

给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。   
叶子节点 是指没有子节点的节点。   

<!--more-->

示例 1：
![](../images/leetcode257/paths-tree.jpg)

输入：root = [1,2,3,null,5]  
输出：["1->2->5","1->3"]  

示例 2：
输入：root = [1]
输出：["1"]


提示：

* 树中节点的数目在范围 [1, 100] 内  
* -100 <= Node.val <= 100  

> **Ps** 由于每个节点都只操作一次，时间复杂度是 O(N)
```
 /**
 * 典型的递归回溯题
 * 只是题目需要返回->的字符串，就有点太多此一举
 */
public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    order(list, root, result);
    return result;
}

public void order(List<TreeNode> list, TreeNode root, List<String> result) {
    //判断左右节点等于空而不是当前节点，可以省略当前节点进入循环，以免造成更加复杂混乱的写法
    if (root.left == null && root.right == null) {
        if (list != null && list.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (TreeNode node : list) {
                builder.append(node.val).append("->");
            }
            result.add(builder.substring(0, builder.length() - 2));
        }
    }
    if (root.left != null) {
        list.add(root.left);
        order(list, root.left, result);
        list.remove(root.left);//回溯，需要把加入的都剔除，不然结果会重复
    }
    if (root.right != null) {
        list.add(root.right);
        order(list, root.right, result);
        list.remove(root.right);//回溯，需要把加入的都剔除，不然结果会重复
    }
}

```