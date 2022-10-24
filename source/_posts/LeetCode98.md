---
title: LeetCode 98. 验证二叉搜索树
date: 2022-10-24 11:52:04
tags:
categories:
- LeetCode
- 二叉树
---

给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

**有效** 二叉搜索树定义如下：

* 节点的左子树只包含 小于 当前节点的数。  
* 节点的右子树只包含 大于 当前节点的数。  
* 所有左子树和右子树自身必须也是二叉搜索树。  

<!--more-->
示例 1：
输入：root = [2,1,3]  
输出：true

示例 2：  
输入：root = [5,1,4,null,null,3,6]  
输出：false  
解释：根节点的值是 5 ，但是右子节点的值是 4 。  

提示：
树中节点数目范围在[1, 10^4] 内
-2^31 <= Node.val <= 2^31 - 1

> 由于中序遍历的的节点，刚好是符合二叉搜索树的规范，是一到从小到大的顺序节点
> 因为题目的值范围超过 Integer.MIN_VALUE 所以需要有一个TreeNode节点的值

```
/**
 * 98. 验证二叉搜索树
 */
public class LeetCode98 {

    private TreeNode node = null;

    /**
     * 可是使用中序遍历，先验证左节点，在验证中间节点，再验证右节点
     * 因为中序遍历的节点，是一个顺序递增的数组
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {//如果节点空，那么默认true
            return true;
        }
        //左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        //中
        if (node != null && root.val <= node.val) {
            return false;
        }
        node = root;
        //右
        boolean right = isValidBST(root.right);
        if (!right) {
            return false;
        }
        return true;
    }
}

```



