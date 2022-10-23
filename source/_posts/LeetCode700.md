---
title: LeetCode 700. 二叉搜索树中的搜索
date: 2022-10-23 15:50:26
tags:
categories:
- LeetCode
- 二叉树
---

给定二叉搜索树（BST）的根节点root和一个整数值val。  
你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。  

<!--more-->


示例 1:
![](../images/leetcode700/tree1.jpg)

输入：root = [4,2,7,1,3], val = 2  
输出：[2,1,3]  

示例 2:
![](../images/leetcode700/tree2.jpg)

输入：root = [4,2,7,1,3], val = 5  
输出：[]  


提示：

数中节点数在[1, 5000]范围内
1 <= Node.val <= 10^7
root是二叉搜索树
1 <= val <= 10^7

```
/**
 * 二叉搜索树，因为是有序的，左节点<中节点<右节点，所以感觉操作起来比一般的二叉树还要简单
 */
public TreeNode searchBST(TreeNode root, int val) {
    LeetCode700 code700 = new LeetCode700();
    TreeNode dfs = code700.dfs(root, val);
    TreeNode bfs = code700.bfs(root, val);
    return dfs;
}

/**
 * 使用递归
 */
public TreeNode dfs(TreeNode root, int val) {
    //如果为空或者找到相同值，返回当前节点
    if (root == null || root.val == val) {
        return root;
    }
    TreeNode node = null;
    if (root.val < val) {//值大于中节点，往右走
        node = dfs(root.right, val);
    } else if (root.val > val) {
        node = dfs(root.left, val);//往左走
    }
    return node;
}

/**
 * 层序遍历
 */
public TreeNode bfs(TreeNode root, int val) {
    while (root != null) {
        if (root.val < val) {//值大于中节点，往右走
            root = root.right;
        } else if (root.val > val) {
            root = root.left;//往左走
        } else {
            return root;
        }
    }
    return null;
}

```

